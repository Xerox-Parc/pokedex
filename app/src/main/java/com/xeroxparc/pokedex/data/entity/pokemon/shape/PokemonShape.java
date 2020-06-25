package com.xeroxparc.pokedex.data.entity.pokemon.shape;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonShape {

	/*
		Shapes used for sorting Pokémon in a Pokédex.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("awesome_names")
	private List<AwesomeName> awesomeNameList;                  // The "scientific" name of this
																// Pokémon shape listed in different
																// languages.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of the Pokémon species
																// that have this shape.
																// (PokemonSpecies)

}
