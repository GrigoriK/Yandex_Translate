package com.example.grishany.yandex_mobilization2017;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryL extends Fragment {

  private static ArrayList<String> languges= new ArrayList<>();/*("Привет:Hello","Это я:It's me","Бутылка:bottle",
           "Вилка:fog","Привет:Hello","Это я:It's me","Бутылка:bottle");*/
    private static  ArrayList<String> favourites= new ArrayList<>();//Arrays.asList("RU:EN","RU:EN","RU:EN","RU:EN","RU:EN","RU:EN","RU:EN");
private  TextView textView;
private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        if(languges.size()==0){
            View view =  inflater.inflate(R.layout.fragment_null, container, false);
            textView=(TextView)view.findViewById(R.id.text_null);
            imageView=(ImageView) view.findViewById(R.id.image_null);
            textView.setText("Нет переводов в истории");
            imageView.setImageResource(R.mipmap.ic_time);
            return view;

        }
        else {

            View view = inflater.inflate(R.layout.fragment_history_l, container, false);
            ListView listView = (ListView) view.findViewById(R.id.listH);
            AdapterH customAdapter = new AdapterH(getContext(), languges, favourites);
            listView.setAdapter(customAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int pos, long id
                ) {

                    Toast.makeText(getActivity(), languges.get(pos), Toast.LENGTH_SHORT).show();


                }
            });
            return view;
        }

    }
    public static void createNote(String lang,String fav){
        languges.add(lang);
        favourites.add(fav);


    }


}
