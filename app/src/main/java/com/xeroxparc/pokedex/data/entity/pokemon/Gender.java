package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class Gender {

	//Genders were introduced in Generation II for the purposes of breeding Pokémon but can also result in visual differences or even different evolutionary lines. Check out Bulbapedia for greater detail.

	private Integer id;                                             //The identifier for this resource.
	private String name;                                            //The name for this resource.
	private List<PokemonSpeciesGender> pokemon_species_details;     //A list of Pokémon species that can be this gender and how likely it is that they will be.
	private List<NamedAPIResource> required_for_evolution;          //A list of Pokémon species that required this gender in order for a Pokémon to evolve into them. (PokemonSpecies)

}
