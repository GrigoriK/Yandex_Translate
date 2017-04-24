package com.example.grishany.yandex_mobilization2017;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Выбор языка,с которого нужно перевести
public class OPtions2 extends AppCompatActivity {

    String[] all_leng ;
    String[] favourites ;
    int color_main;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options2);
      //Получение ресурсов
        favourites=getResources().getStringArray(R.array.favourites);
        all_leng=getResources().getStringArray(R.array.all_leng);
        ListView listView = (ListView) findViewById(R.id.list1_Op);
     //Создание адаптера
        customAdapter = new CustomAdapter(getApplicationContext(), all_leng,favourites);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.d("My log",customAdapter.getItem(position).toString());

            }
        });
        //Создание ActionBar(для кнопки Home)
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
//Событие при нажатии на кнопку Home(Возврат к Main Activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}