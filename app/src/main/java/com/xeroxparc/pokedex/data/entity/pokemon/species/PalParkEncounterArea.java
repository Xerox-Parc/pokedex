package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PalParkEncounterArea {

	@SerializedName("base_score")
	private Integer baseScore;              // The base score given to the player when the
											// referenced Pokémon is caught during a pal park run.

	@SerializedName("rate")
	private Integer rate;                   // The base rate for encountering the referenced Pokémon
											// in this pal park area.

	@SerializedName("area")
	private NamedAPIResource area;          // The pal park area where this encounter happens.
											// (PalParkArea)

}
