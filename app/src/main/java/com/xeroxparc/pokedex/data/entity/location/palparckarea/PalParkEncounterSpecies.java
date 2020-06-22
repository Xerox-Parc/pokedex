package com.xeroxparc.pokedex.data.entity.location.palparckarea;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;


public class PalParkEncounterSpecies {

	@SerializedName("base_score")
	private Integer baseScore;                          // The base score given to the player when
														// this Pokémon is caught during a pal park
														// run.

	@SerializedName("rate")
	private Integer rate;                               // The base rate for encountering this
														// Pokémon in this pal park area.

	@SerializedName("pokemon_species")
	private NamedAPIResource pokemonSpeciesResource;    // The Pokémon species being encountered.
														// (PokemonSpecies)

}
