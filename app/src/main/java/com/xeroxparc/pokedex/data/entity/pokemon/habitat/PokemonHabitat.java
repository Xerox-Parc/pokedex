package com.xeroxparc.pokedex.data.entity.pokemon.habitat;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonHabitat {

	/*
		Habitats are generally different terrain Pokémon can be found in but can also be areas
		designated for rare or legendary Pokémon.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesResource;      // A list of the Pokémon species
																// that can be found in this habitat
																// (PokemonSpecies)

}
