package com.appzone.dukkan.activities_fragments.home_activity.fragment.fragment_home.sub_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appzone.dukkan.R;

public class Fragment_Charging_Cards extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charging_card,container,false);
        initView(view);
        return view;
    }

    public static Fragment_Charging_Cards newInstance()
    {
        return new Fragment_Charging_Cards();
    }
    private void initView(View view) {

    }
}
