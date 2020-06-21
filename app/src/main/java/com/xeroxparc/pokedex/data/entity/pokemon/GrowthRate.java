package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.Description;
import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class GrowthRate {

	//Growth rates are the speed with which Pokémon gain levels through experience. Check out Bulbapedia for greater detail.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private String formula;                             //The formula used to calculate the rate at which the Pokémon species gains level.
	private List<Description> descriptions;             //The descriptions of this characteristic listed in different languages.
	private List<GrowthRateExperienceLevel> levels;     //A list of levels and the amount of experienced needed to atain them based on this growth rate.
	private List<NamedAPIResource> pokemon_species;     //A list of Pokémon species that gain levels at this growth rate. (PokemonSpecies)

}
