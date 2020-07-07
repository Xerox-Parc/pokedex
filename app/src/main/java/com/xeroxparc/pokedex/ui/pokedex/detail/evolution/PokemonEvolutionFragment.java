package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class PokemonEvolutionFragment extends Fragment {
    private PokemonEvolutionBinder binder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binder = new PokemonEvolutionBinder(this);
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }
}