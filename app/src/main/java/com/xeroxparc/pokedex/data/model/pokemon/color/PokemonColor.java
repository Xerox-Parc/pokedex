package com.xeroxparc.pokedex.data.model.pokemon.color;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Colors used for sorting Pokémon in a Pokédex. The color listed in the Pokédex is usually
 * the color most apparent or covering each Pokémon's body. No orange category exists,
 * Pokémon that are primarily orange are listed as red or brown.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "pokemon_color")
public class PokemonColor extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of the Pokémon species that have this color.
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
