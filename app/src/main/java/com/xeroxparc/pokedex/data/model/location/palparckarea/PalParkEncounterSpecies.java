package com.xeroxparc.pokedex.data.model.location.palparckarea;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

/**
 * @author Fabio Buracchi
 */
public class PalParkEncounterSpecies {

	// The base score given to the player when this Pokémon is caught during a pal park run.
	@SerializedName("base_score")
	private Integer baseScore;

	// The base rate for encountering this Pokémon in this pal park area.
	@SerializedName("rate")
	private Integer rate;

	// The Pokémon species being encountered.
	@SerializedName("pokemon_species")
	private PokemonSpecies pokemonSpecies;

	public Integer getBaseScore() {
		return baseScore;
	}

	public Integer getRate() {
		return rate;
	}

	public PokemonSpecies getPokemonSpecies() {
		return pokemonSpecies;
	}

}
