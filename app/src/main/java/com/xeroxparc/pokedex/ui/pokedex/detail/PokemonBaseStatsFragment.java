package com.xeroxparc.pokedex.ui.pokedex.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.R;

public class PokemonBaseStatsFragment extends Fragment {

    public PokemonBaseStatsFragment(){

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_base_stats, container, false);
    }
}