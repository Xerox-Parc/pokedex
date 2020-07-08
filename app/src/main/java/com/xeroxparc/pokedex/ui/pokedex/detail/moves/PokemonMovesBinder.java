package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.pokedex.data.Pokemon;
import com.xeroxparc.pokedex.databinding.FragmentPokemonMovesBinding;
/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonMovesBinder {

    private final FragmentPokemonMovesBinding binding;

    private final PokemonMovesFragment fragment;
    private final PokemonMovesViewModel viewModel;

    PokemonMovesBinder(@NonNull PokemonMovesFragment fragment) {
        this.fragment = fragment;
        binding = FragmentPokemonMovesBinding.inflate(fragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(PokemonMovesViewModel.class);
    }



    View getRoot() {
        return binding.getRoot(); }

    void bind(){
        final PokemonMovesListAdapter componentListAdapter = new PokemonMovesListAdapter() {
            @Override
            void onClickCallback(Pokemon pokemon) {
                //
            }
        };
        binding.recyclerView.setAdapter(componentListAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        viewModel.getListComponent().observe(fragment, componentListAdapter::setComponentList);
    }
}
