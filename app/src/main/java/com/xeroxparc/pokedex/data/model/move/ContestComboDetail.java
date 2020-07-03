package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class ContestComboDetail {

	// A list of moves to use before this move.
	@SerializedName("use_before")
	private List<Move> useBeforeList;

	// A list of moves to use after this move.
	@SerializedName("use_after")
	private List<Move> useAfterList;

	public List<Move> getUseBeforeList() {
		return useBeforeList;
	}

	public List<Move> getUseAfterList() {
		return useAfterList;
	}

}
