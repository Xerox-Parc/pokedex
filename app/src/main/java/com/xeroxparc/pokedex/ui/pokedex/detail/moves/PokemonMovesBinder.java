package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonMove;
import com.xeroxparc.pokedex.databinding.FragmentPokemonMovesBinding;
import com.xeroxparc.pokedex.ui.move.MoveFragmentDirections;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Palmieri Ivan
 */
public class PokemonMovesBinder {

    private final FragmentPokemonMovesBinding binding;

    private final PokemonMovesFragment fragment;
    private final PokemonMovesViewModel viewModel;
    private final int pokeId;

    PokemonMovesBinder(@NonNull PokemonMovesFragment fragment, int pokeId) {
        this.fragment = fragment;
        binding = FragmentPokemonMovesBinding.inflate(fragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(PokemonMovesViewModel.class);
        this.pokeId = pokeId;
    }


    View getRoot() {
        return binding.getRoot();
    }

    void bind() {
        final PokemonMovesListAdapter componentListAdapter = new PokemonMovesListAdapter() {
            @Override
            void onClickCallback(Move move) {
                MoveFragmentDirections.ActionNavMoveToNavMoveDetail action = MoveFragmentDirections.actionNavMoveToNavMoveDetail();
                action.setMoveId(move.getId());
                Navigation.findNavController(fragment.requireView()).
                        navigate(action);
            }
        };

        binding.recycleViewPokemonMoves.setAdapter(componentListAdapter);
        binding.recycleViewPokemonMoves.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        viewModel.getPokemon(pokeId).observe(fragment.getViewLifecycleOwner(), pokemon -> pokemon.ifPresent(retrieved -> {
            List<Move> moves = retrieved.getMoveList().stream().map(PokemonMove::getMove).collect(Collectors.toList());
            componentListAdapter.setMoves(moves);
        }));
    }
}
