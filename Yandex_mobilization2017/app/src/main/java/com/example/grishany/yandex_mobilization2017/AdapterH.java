package com.example.grishany.yandex_mobilization2017;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Grishany on 21.04.2017.
 */
//Адаптер для вывода закладок
public class AdapterH extends BaseAdapter {
    private static boolean posit = true;
    List<String> languges= new ArrayList<>();
    List<String> favourites= new ArrayList<>();

    Context context;
    LayoutInflater inflter;
    String value;


    public AdapterH(Context context,List<String> languges ,List<String> favourites) {
        this.context = context;
            this.languges=languges;
        this.favourites=favourites;
        inflter = (LayoutInflater.from(context));


    }

    @Override
    public int getCount() {
        return (languges.size());
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//Формирование списка закладок
    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        view = inflter.inflate(R.layout.history_l, parent, false);
        final TextView TextView1 = (TextView) view.findViewById(R.id.viewT1);
        final TextView TextView2 = (TextView) view.findViewById(R.id.viewT2);
        final TextView TextView3 = (TextView) view.findViewById(R.id.Tlang);
        int t=languges.get(position).indexOf(":");
        TextView1.setText(languges.get(position).substring(0,t));
        TextView2.setText(languges.get(position).substring(t+1,languges.get(position).length()));
             TextView3.setText(favourites.get(position));
        return view;
    }
}




















