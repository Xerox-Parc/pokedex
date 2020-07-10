package com.xeroxparc.pokedex.ui.ability.detail.filter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.repository.AbilityRepository;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;

import java.util.Optional;

public class AbilityFilterViewModel extends AndroidViewModel {


    private final PokemonRepository pokemonRepository;
    private final AbilityRepository abilityRepository;

    public AbilityFilterViewModel(@NonNull Application application) {
        super(application);
        pokemonRepository = new PokemonRepository(application);
        abilityRepository = new AbilityRepository(application);

    }

    LiveData<Optional<Pokemon>> getPokemon(int id) {
        return pokemonRepository.getPokemon(id);
    }

	public LiveData<Optional<Ability>> getAbility(int id){
		return abilityRepository.getAbility(id);
	}

}
