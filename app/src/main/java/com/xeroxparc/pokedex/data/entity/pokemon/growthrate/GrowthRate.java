package com.xeroxparc.pokedex.data.entity.pokemon.growthrate;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class GrowthRate {

	/*
		Growth rates are the speed with which Pokémon gain levels through experience.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("formula")
	private String formula;                                     // The formula used to calculate the
																// rate at which the Pokémon species
																// gains level.

	@SerializedName("descriptions")
	private List<Description> descriptionList;                  // The descriptions of this
																// characteristic listed in
																// different languages.

	@SerializedName("levels")
	private List<GrowthRateExperienceLevel> levelList;          // A list of levels and the amount
																// of experienced needed to atain
																// them based on this growth rate.

	@SerializedName("pokemon_species")
	private List<NamedAPIResource> pokemonSpeciesListResource;  // A list of Pokémon species that
																// gain levels at this growth rate.
																// (PokemonSpecies)

}
