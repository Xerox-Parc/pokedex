package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;

public class ContestComboSets {

	private ContestComboDetail normal;          //A detail of moves this move can be used before or after, granting additional appeal points in contests.
	@SerializedName("super")
	private ContestComboDetail contestSuper;    //A detail of moves this move can be used before or after, granting additional appeal points in super contests.

}
