package com.xeroxparc.pokedex.data.entity.pokemon.gender;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Gender {

	/*
		Genders were introduced in Generation II for the purposes of breeding Pokémon but can also
		result in visual differences or even different evolutionary lines.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                                 // The identifier for this
																		// resource.

	@SerializedName("name")
	private String name;                                                // The name for this
																		// resource.

	@SerializedName("pokemon_species_details")
	private List<PokemonSpeciesGender> pokemonSpeciesDetailList;        // A list of Pokémon species
																		// that can be this gender
																		// and how likely it is that
																		// they will be.

	@SerializedName("required_for_evolution")
	private List<NamedAPIResource> requiredForEvolutionListResource;    // A list of Pokémon species
																		// that required this gender
																		// in order for a Pokémon to
																		// evolve into them.
																		// (PokemonSpecies)

}
