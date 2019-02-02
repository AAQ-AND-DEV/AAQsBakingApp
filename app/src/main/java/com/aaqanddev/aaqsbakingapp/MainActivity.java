package com.aaqanddev.aaqsbakingapp;


import android.os.Bundle;

import com.aaqanddev.aaqsbakingapp.model.Recipe;
import com.aaqanddev.aaqsbakingapp.util.RecipeAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecipesRV;
    private RecyclerView.Adapter mRecipeAdapter;
    private RecyclerView.LayoutManager mRecipesLayoutMangr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipesRV = findViewById(R.id.recipes_recycler_view);
        mRecipesRV.setHasFixedSize(true);
        mRecipesLayoutMangr = new LinearLayoutManager(this);
        mRecipesRV.setLayoutManager(mRecipesLayoutMangr);
        //TODO getdata and pass into recipeAdapter//
        mRecipeAdapter = new RecipeAdapter();
        mRecipesRV.setAdapter(mRecipeAdapter);
    }
}
