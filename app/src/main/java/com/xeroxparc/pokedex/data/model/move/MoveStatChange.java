package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;

/**
 * @author Fabio Buracchi
 */
public class MoveStatChange {

	//The amount of change.
	@SerializedName("change")
	private Integer change;

	//The stat being affected.
	@SerializedName("stat")
	private Stat stat;

	public Integer getChange() {
		return change;
	}

	public Stat getStat() {
		return stat;
	}

}
