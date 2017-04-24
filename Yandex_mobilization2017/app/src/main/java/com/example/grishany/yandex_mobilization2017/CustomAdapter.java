package com.example.grishany.yandex_mobilization2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Grishany on 19.04.2017.
 */
//Создание Adapter(а)
public class CustomAdapter extends BaseAdapter {
        private static boolean posit = false;
    String[] languges;
    String[] favourites;
    private static String st = "";

    Context context;
    LayoutInflater inflter;
    String value;

//Получение данных
    public CustomAdapter(Context context, String[] languges, String[] favourites) {
        this.context = context;
        this.languges = languges;
        this.favourites = favourites;

        inflter = (LayoutInflater.from(context));


    }

    public static String getString() {
        return st;
    }

    @Override
    public int getCount() {
        return (languges.length+favourites.length+3);
    }

    @Override
    public Object getItem(int position) {
    return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    //Формирование Адаптера из различных View-элементов
       @Override
    public View getView(final int position, View view, final ViewGroup parent) {

        if (position == 0) {
            view = inflter.inflate(R.layout.text_item, parent, false);
            final TextView simpleCheckedTextView = (TextView) view.findViewById(R.id.lang);
            simpleCheckedTextView.setText("Определить язык");
            return view;
        } else if (position == 1) {
            view = inflter.inflate(R.layout.only_text, parent, false);
            final TextView simpleCheckedTextView = (TextView) view.findViewById(R.id.text_grey);
            simpleCheckedTextView.setText("Недавно использованные");
            return view;
        } else if(position >1&& position <5) {
            view = inflter.inflate(R.layout.list_tem, parent, false);
            final CheckedTextView simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.checkedTextView);
            simpleCheckedTextView.setText(favourites[position-2]);
            simpleCheckedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (simpleCheckedTextView.isChecked()&&posit) {

                        value = "un-Checked";
                        simpleCheckedTextView.setCheckMarkDrawable(0);
                        simpleCheckedTextView.setChecked(false);
                        posit = false;

                    } else if (!posit) {
                        st =simpleCheckedTextView.getText().toString();

                        simpleCheckedTextView.setCheckMarkDrawable(R.mipmap.ic_clicked);
                        simpleCheckedTextView.setChecked(true);
                        posit = true;
                    }


                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
         else if(position==5) {
            view = inflter.inflate(R.layout.only_text, parent, false);
            final TextView simpleCheckedTextView = (TextView) view.findViewById(R.id.text_grey);
            simpleCheckedTextView.setText("Все языки");
            return view;
        }
       else{
           view = inflter.inflate(R.layout.list_tem, parent, false);
           final CheckedTextView simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.checkedTextView);
            simpleCheckedTextView.setText(languges[position-6]);

// perform on Click Event Listener on CheckedTextView
            simpleCheckedTextView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (simpleCheckedTextView.isChecked()&&posit) {


                       value = "un-Checked";
                       simpleCheckedTextView.setCheckMarkDrawable(0);
                       simpleCheckedTextView.setChecked(false);
                       posit = false;

                   } else if (!posit) {
                       st = simpleCheckedTextView.getText().toString();

                       simpleCheckedTextView.setCheckMarkDrawable(R.mipmap.ic_clicked);
                       simpleCheckedTextView.setChecked(true);
                       posit = true;
                   }
               }
           });
           return view;
       }


    }
}



















