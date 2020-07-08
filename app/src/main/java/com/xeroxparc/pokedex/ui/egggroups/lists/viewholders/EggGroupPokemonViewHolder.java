package com.xeroxparc.pokedex.ui.egggroups.lists.viewholders;

import android.view.View;
import android.view.View.OnClickListener;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.components.EggGroupChip;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import pl.droidsonroids.gif.GifImageView;

public class EggGroupPokemonViewHolder extends RecyclerView.ViewHolder {

    private ItemRowEggGroupPokemonBinding binding;

    public EggGroupPokemonViewHolder(@NonNull ItemRowEggGroupPokemonBinding binding, OnClickListener onClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.pokemonCardFrame.setOnClickListener(onClickListener);
    }

    public void setPokemonName(String pokemonName) {
        binding.pokemonName.setText(pokemonName);
    }


    public void addEggGroupChip(EggGroupChip eggGroupChip) {
        binding.eggGroups.addView(eggGroupChip);
    }

    public GifImageView getImage() {
        return binding.pokemonImage;
    }

    public void resetImage(){
        binding.pokemonImage.setImageResource(R.drawable.img_loading_placeholder);
    }

    public void resetEggGroups(){
        binding.eggGroups.removeAllViews();
    }

}
