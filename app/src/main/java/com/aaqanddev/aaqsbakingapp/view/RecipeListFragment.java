package com.aaqanddev.aaqsbakingapp.view;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaqanddev.aaqsbakingapp.R;
import com.aaqanddev.aaqsbakingapp.model.Recipe;
import com.aaqanddev.aaqsbakingapp.util.RecipeAdapter;
import com.aaqanddev.aaqsbakingapp.util.RetroInterface;
import com.aaqanddev.aaqsbakingapp.util.RetroService;
import com.google.gson.Gson;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeListFragment extends Fragment {

    private static final String TAG = RecipeListFragment.class.getSimpleName();
    private RecyclerView mRecipesRV;
    private List<Recipe> mRecipes;
    private RecyclerView.Adapter mRecipeAdapter;
    private RecyclerView.LayoutManager mRecipesLayoutMangr;
    private Retrofit retro;

    public RecipeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        mRecipesRV = rootView.findViewById(R.id.recipes_recycler_view);
        //should this actually be the frame layout root view?
        //TODO move data fetch here from MainActivity?

        mRecipesRV.setHasFixedSize(true);
        mRecipesLayoutMangr = new LinearLayoutManager(this.getContext());
        mRecipesRV.setLayoutManager(mRecipesLayoutMangr);
        //TODO getdata and pass into recipeAdapter//
        retro = RetroService.getRetroInstance(new Gson());
        RetroInterface retroInterface = retro.create(RetroInterface.class);
        if (mRecipes == null) {
            Call<List<Recipe>> call = retroInterface.getRecipes();
            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    int statusCode = response.code();
                    mRecipes = response.body();
                    Log.d(TAG, response.body().toString() + mRecipes.get(0).getName());
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.e(TAG, "error fetching data " + t.getMessage());
                    t.printStackTrace();
                }
            });
        }
        if (mRecipes != null){
            mRecipeAdapter = new RecipeAdapter(mRecipes);
            mRecipesRV.setAdapter(mRecipeAdapter);
        }
        else {
            Log.i(TAG, "the recipe list is null.");
        }
        return rootView;
    }

}
