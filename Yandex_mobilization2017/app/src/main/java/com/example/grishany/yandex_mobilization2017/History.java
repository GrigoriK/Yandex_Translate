package com.example.grishany.yandex_mobilization2017;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class History extends Fragment {
    private TabLayout allTabs;
    HistoryL Frgament1;
    Favourites Frgament2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view_V = inflater.inflate(R.layout.fragment_history, container, false);
        allTabs = (TabLayout) view_V.findViewById(R.id.tabs2);
        bindWidgetsWithAnEvent();
        setupTabLayout();
        return view_V;
    }

    private void setupTabLayout() {
        Frgament1 = new HistoryL();
        Frgament2 = new Favourites();
        allTabs.addTab(allTabs.newTab().setText("История"),true);
        allTabs.addTab(allTabs.newTab().setText("Избранное"));


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


    private void setCurrentTabFragment(int tabPosition)
    {
        switch (tabPosition)
        {
            case 0 :

                Toast.makeText(getActivity(), "1st",Toast.LENGTH_SHORT).show();
                replaceFragment(Frgament1);
                break;
            case 1 :
                Toast.makeText(getActivity(), "2nd app",Toast.LENGTH_SHORT).show();

                replaceFragment(Frgament2);
                break;

        }
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
         ft.replace(R.id.frame_container2, fragment);

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}



