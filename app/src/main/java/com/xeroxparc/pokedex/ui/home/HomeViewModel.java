package com.xeroxparc.pokedex.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;

import java.util.Objects;

/**
 * View model class.
 * Maintains state of the model data.
 * Implement the business logic.
 *
 * @author Fabio Buracchi
 */
public class HomeViewModel extends AndroidViewModel {


	private final PokemonRepository pokemonRepository;

	private final LiveData<PagedList<Pokemon>> pokemonList;

	public HomeViewModel(@NonNull Application application) {
		super(application);
		pokemonRepository = new PokemonRepository(application);
		pokemonList = pokemonRepository.getPokemonList();
	}

	public LiveData<PagedList<Pokemon>> getPokemonList() {
		return pokemonList;
	}

	void invalidate() {
		Objects.requireNonNull(pokemonList.getValue()).getDataSource().invalidate();
		pokemonRepository.fetchPokemonList();
	}

}
