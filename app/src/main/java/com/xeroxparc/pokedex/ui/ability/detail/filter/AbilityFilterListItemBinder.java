package com.xeroxparc.pokedex.ui.ability.detail.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xeroxparc.pokedex.databinding.ItemAbilityFilterBinding;


public class AbilityFilterListItemBinder {

    private final ItemAbilityFilterBinding binding;
    private TextView name;

    AbilityFilterListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemAbilityFilterBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }

    View getRoot(){
        return binding.getRoot();
    }

    void bind() {
        name = binding.textViewName;
    }

    TextView getNameView(){
        return name;
    }

    ImageView getImageView(){
        return binding.imageView4;
    }
}
