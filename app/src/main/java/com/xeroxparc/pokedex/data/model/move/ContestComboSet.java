package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class ContestComboSet {

	// A detail of moves this move can be used before or after, granting additional appeal points in contests.
	@SerializedName("normal")
	private ContestComboDetail contestNormal;

	// A detail of moves this move can be used before or after, granting additional appeal points in super contests.
	@SerializedName("super")
	private ContestComboDetail contestSuper;

	public ContestComboDetail getContestNormal() {
		return contestNormal;
	}

	public ContestComboDetail getContestSuper() {
		return contestSuper;
	}

}
