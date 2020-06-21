package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PalParkEncounterArea {

	private Integer base_score;         //The base score given to the player when the referenced Pokémon is caught during a pal park run.
	private Integer rate;               //The base rate for encountering the referenced Pokémon in this pal park area.
	private NamedAPIResource area;      //The pal park area where this encounter happens. (PalParkArea)

}
