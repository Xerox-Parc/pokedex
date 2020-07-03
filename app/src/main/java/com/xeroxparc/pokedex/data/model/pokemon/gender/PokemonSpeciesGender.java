package com.xeroxparc.pokedex.data.model.pokemon.gender;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

/**
 * @author Fabio Buracchi
 */
public class PokemonSpeciesGender {

	// The chance of this Pokémon being female, in eighths, or -1 for genderless.
	@SerializedName("rate")
	private Integer rate;

	// A Pokémon species that can be the referenced gender.
	@SerializedName("pokemon_species")
	private PokemonSpecies pokemonSpecies;

	public Integer getRate() {
		return rate;
	}

	public PokemonSpecies getPokemonSpecies() {
		return pokemonSpecies;
	}

}
