package com.xeroxparc.pokedex.data.entity.pokemon.color;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonColor {

	/*
		Colors used for sorting Pokémon in a Pokédex. The color listed in the Pokédex is usually
		the color most apparent or covering each Pokémon's body. No orange category exists,
		Pokémon that are primarily orange are listed as red or brown.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of the Pokémon species
																// that have this color.
																// (PokemonSpecies)

}
