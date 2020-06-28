package com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats;


import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.nature.Nature;

/**
 * @author Fabio Buracchi
 */
public class NaturePokeathlonStatAffect {

	// The maximum amount of change to the referenced Pokéathlon stat.
	@SerializedName("max_change")
	private Integer maxChange;

	// The nature causing the change.
	@SerializedName("nature")
	private Nature nature;

}
