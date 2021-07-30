package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.repository.MoveRepository;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;

import java.util.Optional;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokemonMovesViewModel extends AndroidViewModel {

    private final PokemonRepository pokemonRepository;
    private final MoveRepository moveRepository;

    public PokemonMovesViewModel(@NonNull Application application) {
        super(application);
        pokemonRepository = new PokemonRepository(application);
        moveRepository = new MoveRepository(application);
    }

    public LiveData<Optional<Move>> getMove(int id) { return moveRepository.getMove(id); }
    public LiveData<Optional<Pokemon>> getPokemon(int id) { return pokemonRepository.getPokemon(id); }
}
