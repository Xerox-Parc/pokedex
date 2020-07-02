package com.xeroxparc.pokedex.data.model.game.pokedex;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

/**
 * @author Fabio Buracchi
 */
public class PokemonEntry {

	// The index of this Pokémon species entry within the Pokédex.
	@SerializedName("entry_number")
	private Integer entryNumber;

	// The Pokémon species being encountered.
	@SerializedName("pokemon_species")
	private PokemonSpecies pokemonSpecies;

	public Integer getEntryNumber() {
		return entryNumber;
	}

	public PokemonSpecies getPokemonSpecies() {
		return pokemonSpecies;
	}

}
