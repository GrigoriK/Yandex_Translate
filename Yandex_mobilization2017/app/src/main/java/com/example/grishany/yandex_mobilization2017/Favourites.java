package com.example.grishany.yandex_mobilization2017;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

//Класс для создания списка закладок
public class Favourites extends Fragment {

    private static ArrayList<String> languges= new ArrayList<>();
    private static  ArrayList<String> favourites= new ArrayList<>();
    private  TextView textView;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(languges.size()==0){
            View view =  inflater.inflate(R.layout.fragment_null, container, false);
            textView=(TextView)view.findViewById(R.id.text_null);
            imageView=(ImageView) view.findViewById(R.id.image_null);
            textView.setText("Нет переводов в избранном");
            imageView.setImageResource(R.mipmap.ic_fav);
            return view;

        }
        else {

            View view = inflater.inflate(R.layout.fragment_history_l, container, false);
            ListView listView = (ListView) view.findViewById(R.id.listH);
            AdapterH customAdapter = new AdapterH(getContext(), languges, favourites);
            listView.setAdapter(customAdapter);

            return view;
        }

    }
    public static void createNote(String lang,String fav){
        languges.add(lang);
        favourites.add(fav);


    }


}
