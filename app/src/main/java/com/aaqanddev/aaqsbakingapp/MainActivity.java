package com.aaqanddev.aaqsbakingapp;


import android.os.Bundle;
import android.util.Log;

import com.aaqanddev.aaqsbakingapp.model.Recipe;
import com.aaqanddev.aaqsbakingapp.util.RecipeAdapter;
import com.aaqanddev.aaqsbakingapp.util.RetroInterface;
import com.aaqanddev.aaqsbakingapp.util.RetroService;
import com.aaqanddev.aaqsbakingapp.view.RecipeListFragment;
import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeListFragment recipeFrag = new RecipeListFragment();

        FragmentManager fragMangr = getSupportFragmentManager();

        fragMangr.beginTransaction()
                .add(R.id.recipes_container, recipeFrag)
                .commit();

    }
}
