package com.aaqanddev.aaqsbakingapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaqanddev.aaqsbakingapp.R;

import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeListFragment extends Fragment {


    public RecipeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        RecyclerView recipes_rv = rootView.findViewById(R.id.recipes_recycler_view);
        //should this actually be the frame layout root view?
        //TODO move data fetch here from MainActivity?
        return recipes_rv;
    }

}
