package com.xeroxparc.pokedex.data.entity.pokemon.gender;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonSpeciesGender {

	@SerializedName("rate")
	private Integer rate;                                       // The chance of this Pokémon being
																// female, in eighths,
																// or -1 for genderless.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A Pokémon species that can be the
																// referenced gender.
																// (PokemonSpecies)

}
