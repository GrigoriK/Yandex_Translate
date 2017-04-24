package com.example.grishany.yandex_mobilization2017;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

//Иконки вкладок
    private int[] tabIcons = {
            R.drawable.ic_compare_arrows_black_24dp,
            R.drawable.ic_turned_in_black_24dp,


    };
    Main_fragment fragmentOne;
    History fragmentTwo;
     private TabLayout allTabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllWidgets();
        bindWidgetsWithAnEvent();
        setupTabLayout();
        setupTabIcons();

    }

//Доступ к элемент Tabs
    private void getAllWidgets() {
        allTabs = (TabLayout) findViewById(R.id.tabs);
    }
//Инициализация перменных фрагментов и формирование 2х вкладок
    private void setupTabLayout() {
        fragmentOne = new Main_fragment();
        fragmentTwo = new History();
        allTabs.addTab(allTabs.newTab().setText(""),true);
        allTabs.addTab(allTabs.newTab());


    }
    private void bindWidgetsWithAnEvent()
    {
        allTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    //Присваивание каждой вкладке иконки
    private void setupTabIcons() {
        allTabs.getTabAt(0).setIcon(tabIcons[0]);
        allTabs.getTabAt(1).setIcon(tabIcons[1]);

    }
//Переход с одной вкладки в другую
    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :
                replaceFragment(fragmentOne);
                break;
            case 1 :
                  replaceFragment(fragmentTwo);
                    break;

        }
    }
    //Замена фрагментов при переключении вкладок
    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}
