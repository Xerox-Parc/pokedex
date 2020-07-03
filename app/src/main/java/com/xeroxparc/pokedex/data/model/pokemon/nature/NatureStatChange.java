package com.xeroxparc.pokedex.data.model.pokemon.nature;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats.PokeathlonStat;

/**
 * @author Fabio Buracchi
 */
public class NatureStatChange {

	// The amount of change.
	@SerializedName("max_change")
	private Integer maxChange;

	// The stat being affected.
	@SerializedName("pokeathlon_stat")
	private PokeathlonStat pokeathlonStat;

	public Integer getMaxChange() {
		return maxChange;
	}

	public PokeathlonStat getPokeathlonStat() {
		return pokeathlonStat;
	}

}
