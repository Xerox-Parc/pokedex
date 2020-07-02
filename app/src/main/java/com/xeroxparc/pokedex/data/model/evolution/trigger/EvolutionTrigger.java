package com.xeroxparc.pokedex.data.model.evolution.trigger;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Evolution triggers are the events and conditions that cause a Pokémon to evolve.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "evolution_trigger")
public class EvolutionTrigger extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of pokemon species that result from this evolution trigger.
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PokemonSpecies> getPokemonSpeciesList() {
		return pokemonSpeciesList;
	}

	public void setPokemonSpeciesList(List<PokemonSpecies> pokemonSpeciesList) {
		this.pokemonSpeciesList = pokemonSpeciesList;
	}

}
