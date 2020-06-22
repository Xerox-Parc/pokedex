package com.xeroxparc.pokedex.data.entity.pokemon.stats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoveStatAffectSets {

	@SerializedName("increase")
	private List<MoveStatAffect> increaseList;          //A list of moves and how they change the
														// referenced stat.

	@SerializedName("decrease")
	private List<MoveStatAffect> decreaseList;          //A list of moves and how they change the
														// referenced stat.

}
