package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ContestComboDetail {

	@SerializedName("use_before")
	private List<NamedAPIResource> useBeforeListResource;   // A list of moves to use before this
															// move.
															// (Move)

	@SerializedName("use_after")
	private List<NamedAPIResource> useAfterListResource;    // A list of moves to use after this
															// move.
															// (Move)

}
