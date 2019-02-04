package com.aaqanddev.aaqsbakingapp;


import android.os.Bundle;

import com.aaqanddev.aaqsbakingapp.view.RecipeListFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //I guess that onSavedInstanceState of a hosted fragment
        //automatically is checked/preserved with onCreate(savedInstanceState)
        if (savedInstanceState == null){
        /* TODO refactor this code to use in detailsView (fragment_recipe.xml)
            RecipeListFragment recipeFrag = new RecipeListFragment();

            FragmentManager fragMangr = getSupportFragmentManager();

            fragMangr.beginTransaction()
                    .add(R.id.recipes_container, recipeFrag)
                    .commit();
        */
        }

    }
}
