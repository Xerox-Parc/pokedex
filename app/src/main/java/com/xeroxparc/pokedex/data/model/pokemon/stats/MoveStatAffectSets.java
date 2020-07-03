package com.xeroxparc.pokedex.data.model.pokemon.stats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class MoveStatAffectSets {

	// A list of moves and how they change the referenced stat.
	@SerializedName("increase")
	private List<MoveStatAffect> increaseList;

	// A list of moves and how they change the referenced stat.
	@SerializedName("decrease")
	private List<MoveStatAffect> decreaseList;

	public List<MoveStatAffect> getIncreaseList() {
		return increaseList;
	}

	public List<MoveStatAffect> getDecreaseList() {
		return decreaseList;
	}

}
