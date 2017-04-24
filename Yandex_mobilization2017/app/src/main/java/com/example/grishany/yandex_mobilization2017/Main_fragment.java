package com.example.grishany.yandex_mobilization2017;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class Main_fragment extends Fragment implements View.OnClickListener {
   private ImageView image1;
    private   ImageView image2;
    private  YandexTask task;
    private  TextView  text_original;
    private  TextView text_translate;
    private  TextView translateT;
    private  EditText editT;
    private ImageView imageX;
    private ImageView full;
    private String text="";
    private  ImageView fav ;
    private String changeL="ru-en";
    private ImageView Inter;
    private  ImageView Imag;
    private boolean check=false;




    private Boolean isEpmty=false;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_fragment, container, false);
        //Инициализация всех переменных
         translateT=(TextView) rootView.findViewById(R.id.textTrans);
         image1 =(ImageView)  rootView.findViewById(R.id.change);
        editT = (EditText) rootView.findViewById(R.id.editText);
        full = (ImageView) rootView.findViewById(R.id.image_full_screen);
        fav = (ImageView) rootView.findViewById(R.id.Transmit);
        Inter = (ImageView) rootView.findViewById(R.id.image_sound2);
        Imag = (ImageView) rootView.findViewById(R.id.image_sound1);
        image2 =(ImageView)  rootView.findViewById(R.id.image_favourites);
        imageX=(ImageView) rootView.findViewById(R.id.delete);
        text_original =(TextView)  rootView.findViewById(R.id.language_original);
        text_translate =(TextView)  rootView.findViewById(R.id.language_translate);
        //Писваивание Listener каждому элементу на который можно нажать
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        imageX.setOnClickListener(this);
        full.setOnClickListener(this);
        text_original.setOnClickListener(this);
        text_translate.setOnClickListener(this);
        fav.setOnClickListener(this);
        ImageVisibility(rootView);

//Отслеживание изменение текста в EditText
        editT.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
            @Override
            public void afterTextChanged(Editable s) {
                text=editT.getText().toString();
                task = new YandexTask();
                task.execute();


            }
        });
        return rootView;

    }


    public void ImageVisibility(View view){
        final Handler handler = new Handler();


        handler.post(new Runnable() {
            @Override
            public void run() {
                String text=editT.getText().toString();
              if((!(text.equals("")))){

                  full.setVisibility(View.VISIBLE);
                  fav.setVisibility(View.VISIBLE);
                  Inter.setVisibility(View.VISIBLE);
                  Imag.setVisibility(View.VISIBLE);
                  imageX.setVisibility(View.VISIBLE);
                  image2.setVisibility(View.VISIBLE);
              }
              else{
                  full.setVisibility(View.INVISIBLE);
                  fav.setVisibility(View.INVISIBLE);
                  Inter.setVisibility(View.INVISIBLE);
                  Imag.setVisibility(View.INVISIBLE);
                  imageX.setVisibility(View.INVISIBLE);
                  image2.setVisibility(View.INVISIBLE);
              }
                handler.postDelayed(this,1000);
            }
        });



    }
    class YandexTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
             String text2="";
            try {
                text2 = Yandex_translate.translate(changeL,text);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return text2;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            translateT.setText(result);
        }
    }






    @Override
    public void onDetach() {
        super.onDetach();

    }

//Нажатие на иконки
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Смена языка текста и языка перевода
            case R.id.change:
                String stroc=text_original.getText().toString();
                 text_original.setText(text_translate.getText());
                text_translate.setText(stroc);
                int dash=changeL.indexOf("-");
                changeL=changeL.substring(dash+1,changeL.length())+"-"+changeL.substring(0,dash);
                task = new YandexTask();
                task.execute();
                break;
            //Добавление вкладки избранное
            case R.id.image_favourites:
                check=!check;
                if(check) {
                    String  note=editT.getText().toString()+":"+
                            translateT.getText().toString();

                    image2.setImageResource(R.drawable.ic_favourites);
                     Favourites.createNote(note,changeL);
                }
                else{
                    image2.setImageResource(R.drawable.ic_turned_in_black_24dp);

                }
                break;
            //Вывод выбора текста перевода
            case R.id.language_translate:
                Intent intent1 = new Intent(getActivity(),ChooseTranslate.class);
                startActivity(intent1);
                break;
            //Выбор текста
            case R.id.language_original:
                Intent inten2 = new Intent(getActivity(),OPtions2.class);
                startActivity(inten2);
                break;
            //Очистка EditText
            case R.id.delete:
                 editT.setText("");
                break;
            //Вывод на полный экран текста перевода
            case R.id.image_full_screen:
                Intent intent3 = new Intent(getActivity(),FullScreenActivity.class);
                intent3.putExtra(FullScreenActivity.EXTRA_MESSAGE,translateT.getText().toString());
                startActivity(intent3);
                break;
              //Передача переведённого текста с помощью встроенных приложений устройства.
            case R.id.Transmit:
                Intent intent4 = new Intent(Intent.ACTION_SEND);
                intent4.setType("text/plain");
                intent4.putExtra(Intent.EXTRA_TEXT,translateT.getText().toString());
                startActivity(intent4);
                break;
            default:
        }
    }



}
