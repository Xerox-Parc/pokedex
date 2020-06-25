package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class MoveStatChange {

	@SerializedName("change")
	private Integer change;                     //The amount of change.

	@SerializedName("stat")
	private NamedAPIResource statResource;      //The stat being affected.
												// (Stat)

}
