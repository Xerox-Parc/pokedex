package com.xeroxparc.pokedex.data.entity.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class MoveStatAffect {

	@SerializedName("change")
	private Integer change;                             // The maximum amount of change to the
														// referenced stat.

	@SerializedName("move")
	private List<NamedAPIResource> moveListResource;    // The move causing the change.
														// (Move)

}
