package com.aaqanddev.aaqsbakingapp;


import android.os.Bundle;
import android.util.Log;

import com.aaqanddev.aaqsbakingapp.model.Recipe;
import com.aaqanddev.aaqsbakingapp.util.RecipeAdapter;
import com.aaqanddev.aaqsbakingapp.util.RetroInterface;
import com.aaqanddev.aaqsbakingapp.util.RetroService;
import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecipesRV;
    private List<Recipe> mRecipes;
    private RecyclerView.Adapter mRecipeAdapter;
    private RecyclerView.LayoutManager mRecipesLayoutMangr;
    private Retrofit retro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipesRV = findViewById(R.id.recipes_recycler_view);
        mRecipesRV.setHasFixedSize(true);
        mRecipesLayoutMangr = new LinearLayoutManager(this);
        mRecipesRV.setLayoutManager(mRecipesLayoutMangr);
        //TODO getdata and pass into recipeAdapter//
        retro = RetroService.getRetroInstance(new Gson(), new OkHttpClient());
        RetroInterface retroInterface = retro.create(RetroInterface.class);
        Call<List<Recipe>> call = retroInterface.getRecipes();
        call.enqueue(new Callback<List<Recipe>>(){
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                int statusCode = response.code();
                mRecipes = response.body();
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e(TAG, "error fetching data " + t.getMessage());
                t.printStackTrace();
            }
        });
        mRecipeAdapter = new RecipeAdapter(mRecipes);
        mRecipesRV.setAdapter(mRecipeAdapter);
    }
}
