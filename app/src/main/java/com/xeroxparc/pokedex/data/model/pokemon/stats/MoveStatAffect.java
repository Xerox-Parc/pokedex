package com.xeroxparc.pokedex.data.model.pokemon.stats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;

/**
 * @author Fabio Buracchi
 */
public class MoveStatAffect {

	// The maximum amount of change to the referenced stat.
	@SerializedName("change")
	private Integer change;

	// The move causing the change.
	@SerializedName("move")
	private Move move;

}
