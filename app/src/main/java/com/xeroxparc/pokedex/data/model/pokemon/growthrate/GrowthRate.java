package com.xeroxparc.pokedex.data.model.pokemon.growthrate;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Growth rates are the speed with which Pokémon gain levels through experience.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class GrowthRate extends NamedApiResource {

	// The formula used to calculate the rate at which the Pokémon species gains level.
	@SerializedName("formula")
	private String formula;

	// The descriptions of this characteristic listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// A list of levels and the amount of experienced needed to atain them based on this growth rate.
	@SerializedName("levels")
	private List<GrowthRateExperienceLevel> levelList;

	// A list of Pokémon species that gain levels at this growth rate.
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

}
