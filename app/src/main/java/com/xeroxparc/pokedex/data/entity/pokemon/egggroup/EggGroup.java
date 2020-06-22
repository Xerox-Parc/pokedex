package com.xeroxparc.pokedex.data.entity.pokemon.egggroup;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EggGroup {

	/*
		Egg Groups are categories which determine which Pokémon are able to interbreed.
		Pokémon may belong to either one or two Egg Groups.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this
																// resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource
																// listed in different languages.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of all Pokémon species
																// that are members of this
																// egg group.
																// (PokemonSpecies)

}
