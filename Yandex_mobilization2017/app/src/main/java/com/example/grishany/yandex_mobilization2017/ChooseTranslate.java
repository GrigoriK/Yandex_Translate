package com.example.grishany.yandex_mobilization2017;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;
//Выбор язвка перевода
public class ChooseTranslate extends AppCompatActivity {
//Всё анологично с классом Options2
    String[] all_leng;
    String[] favourites;
    String[] all_leng2;
    int color_main;
    HashMap<String,String> map1 = new HashMap<>();

    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_translate);
        color_main = R.color.frame_unclicked;
        // initiate a ListView
        favourites = getResources().getStringArray(R.array.favourites);
        all_leng = getResources().getStringArray(R.array.all_leng);
        all_leng2=getResources().getStringArray(R.array.all_leng2);
        for(int i=0;i<all_leng.length-1;i++){
            map1.put(all_leng[i],all_leng2[i]);
        }
        ListView listView = (ListView) findViewById(R.id.lisT);
        // set the adapter to fill the data in ListView
        customAdapter = new CustomAdapter(getApplicationContext(), all_leng, favourites);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.d("My log", customAdapter.getItem(position).toString());

            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

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
