package com.xeroxparc.pokedex.ui.pokedex.detail.evolution;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.pokedex.data.Pokemon;
import com.xeroxparc.pokedex.databinding.FragmentPokemonEvolutionBinding;
/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonEvolutionBinder {

    private final FragmentPokemonEvolutionBinding binding;

    private final PokemonEvolutionFragment fragment;
    private final PokemonEvolutionViewModel viewModel;

    PokemonEvolutionBinder(@NonNull PokemonEvolutionFragment fragment) {
        this.fragment = fragment;
        binding = FragmentPokemonEvolutionBinding.inflate(fragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(PokemonEvolutionViewModel.class);
    }



    View getRoot() {
        return binding.getRoot(); }

    void bind(){

        final PokemonEvolutionListAdapter componentListAdapter = new PokemonEvolutionListAdapter() {
            @Override
            void onClickCallback(Pokemon pokemon) {
              //
            }
        };
        binding.recycleViewPokemonEvolution.setAdapter(componentListAdapter);
        binding.recycleViewPokemonEvolution.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        viewModel.getListComponent().observe(fragment, componentListAdapter::setComponentList);
    }



}
