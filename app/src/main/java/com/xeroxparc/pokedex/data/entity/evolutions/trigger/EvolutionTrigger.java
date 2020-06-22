package com.xeroxparc.pokedex.data.entity.evolutions.trigger;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EvolutionTrigger {

	/*
		Evolution triggers are the events and conditions that cause a Pokémon to evolve.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of pokemon species that
																// result from this evolution
																// trigger.
																// (PokemonSpecies)

}
