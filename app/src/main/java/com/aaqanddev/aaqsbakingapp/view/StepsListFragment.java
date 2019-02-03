package com.aaqanddev.aaqsbakingapp.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaqanddev.aaqsbakingapp.R;

/**
 * A simple {@link } subclass.
 */
public class StepsListFragment extends androidx.fragment.app.Fragment {


    public StepsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_steps_list, container, false);
    }

}
