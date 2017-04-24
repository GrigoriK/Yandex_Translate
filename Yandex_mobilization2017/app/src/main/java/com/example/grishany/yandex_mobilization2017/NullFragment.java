package com.example.grishany.yandex_mobilization2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NullFragment extends Fragment {
    //Данный фрагмент выводиться при отсутвии Закладок и Истории


    public NullFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_null, container, false);
    }

}
