package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.pokedex.ui.pokedex.detail.PokemonBaseStatsFragmentArgs;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonEvolutionFragment extends Fragment {
    private PokemonEvolutionBinder binder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        binder = new PokemonEvolutionBinder(this);
        int pokeId = PokemonEvolutionFragmentArgs.fromBundle(requireArguments()).getPokemonId();
        Log.d("Evolution InfoPokemon", String.valueOf(pokeId));
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }
}