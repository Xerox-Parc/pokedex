package com.xeroxparc.pokedex.data.model.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.location.palparckarea.PalParkArea;

/**
 * @author Fabio Buracchi
 */
public class PalParkEncounterArea {

	// The base score given to the player when the referenced Pokémon is caught during a pal park run.
	@SerializedName("base_score")
	private Integer baseScore;

	// The base rate for encountering the referenced Pokémon in this pal park area.
	@SerializedName("rate")
	private Integer rate;

	// The pal park area where this encounter happens.
	@SerializedName("area")
	private PalParkArea area;

}
