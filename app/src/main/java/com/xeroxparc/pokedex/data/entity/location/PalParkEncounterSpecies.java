package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;


public class PalParkEncounterSpecies {

	//Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific to Pal Park.

	private Integer base_score;                 //The base score given to the player when this Pokémon is caught during a pal park run.
	private Integer rate;                       //The base rate for encountering this Pokémon in this pal park area.
	private NamedAPIResource pokemon_species;   //The Pokémon species being encountered. (PokemonSpecies)

}
