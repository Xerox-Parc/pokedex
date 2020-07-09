package com.xeroxparc.pokedex.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.xeroxparc.pokedex.data.database.PokeDatabase;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.remote.PokeApi;
import com.xeroxparc.pokedex.data.remote.PokeApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.HttpException;

/**
 * Repository class.
 * Encapsulate the logic required to access data sources.
 *
 * @author Fabio Buracchi
 */
public class PokemonRepository2 {

	private final PokeApiService service;
	private final PokeDatabase database;

	public PokemonRepository2(Application application) {
		service = PokeApi.getService();
		database = PokeDatabase.getDatabase(application);
	}

	public LiveData<Pokemon> getPokemon(int id, boolean forceRefresh) {
		MutableLiveData<Pokemon> pokemon = new MutableLiveData<>();
		AsyncTask.execute(() -> {
			if (forceRefresh || database.pokemonDao().getPokemon(id) == null) {
				try {
					database.pokemonDao().insert(service.getPokemon(id).result());
				} catch (IOException | HttpException e) {
					e.printStackTrace();
				}
			}
			pokemon.postValue(database.pokemonDao().getPokemon(id));
		});
		return pokemon;
	}

	public LiveData<PagedList<Pokemon>> getPokemonList() {
		AsyncTask.execute(() -> {
			if (database.pokemonDao().getPagedList() == null) {
				try {
					database.pokemonDao().insert(
						service.getPokemonList(-1, 0).result().getResults()
					);
				} catch (IOException | HttpException e) {
					e.printStackTrace();
				}
			}
		});
		return new LivePagedListBuilder<>(
				database.pokemonDao().getPagedList(),
				new PagedList.Config.Builder()
						.setPageSize(15)
						.setPrefetchDistance(100)
						.setEnablePlaceholders(true)
						.build()
		).build();
	}

	public void fetchPokemonList() {
		AsyncTask.execute(() -> {
			List<Pokemon> list;
			try {
				database.pokemonDao().insert(
						service.getPokemonList(-1, 0).result().getResults()
				);
			} catch (IOException | HttpException e) {
				e.printStackTrace();
			}
		});
	}

}
