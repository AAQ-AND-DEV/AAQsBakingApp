package com.aaqanddev.aaqsbakingapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaqanddev.aaqsbakingapp.R;
import com.aaqanddev.aaqsbakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private ArrayList<Recipe> mRecipes;

    public RecipeAdapter(List<Recipe> recipes){
        mRecipes = new ArrayList<Recipe>(recipes);
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recipeView = inflater.inflate(R.layout.recipe_item,parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(recipeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe thisRecipe = mRecipes.get(position);
        //TODO figure out how to get image from Recipe String
        //holder.recipe_img.setImageURI(mRecipes.get(position).getImage());
        holder.recipe_name.setText(thisRecipe.getName());
        holder.recipe_servings.setText(thisRecipe.getServings());
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        public ImageView recipe_img;
        public TextView recipe_name;
        public TextView recipe_servings;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipe_name = itemView.findViewById(R.id.recipe_name);
            recipe_servings = itemView.findViewById(R.id.recipe_servings);
            recipe_img = itemView.findViewById(R.id.recipe_img);
        }
    }
}
