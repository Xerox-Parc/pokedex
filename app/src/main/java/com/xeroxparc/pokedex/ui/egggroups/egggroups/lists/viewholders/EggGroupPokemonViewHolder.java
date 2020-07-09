package com.xeroxparc.pokedex.ui.egggroups.egggroups.lists.viewholders;

import android.view.View;
import android.view.View.OnClickListener;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.ItemRowEggGroupPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.components.EggGroupChip;
import com.xeroxparc.pokedex.ui.egggroups.fragments.details.EggGroupDetailsNavigationRequester;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import pl.droidsonroids.gif.GifImageView;

public class EggGroupPokemonViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
    private static final String TAG = "EggGroupPokemonViewHold";
    private ItemRowEggGroupPokemonBinding binding;
    private int pokemonId = -1;
    private EggGroupDetailsNavigationRequester navigationRequester;

    public EggGroupPokemonViewHolder(@NonNull ItemRowEggGroupPokemonBinding binding, EggGroupDetailsNavigationRequester navigationRequester) {
        super(binding.getRoot());
        this.binding = binding;
        this.navigationRequester = navigationRequester;
        this.binding.pokemonCardFrame.setOnClickListener(this);
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

    public void resetImage() {
        binding.pokemonImage.setImageResource(R.drawable.img_loading_placeholder);
    }

    public void resetEggGroups() {
        binding.eggGroups.removeAllViews();
    }


    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public void resetPokemonId() {
        this.pokemonId = -1;
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() != EggGroupChip.TAG) {
            if (pokemonId != -1) {
                navigationRequester.navigateToPokemon(pokemonId);
            }
        }
    }
}
