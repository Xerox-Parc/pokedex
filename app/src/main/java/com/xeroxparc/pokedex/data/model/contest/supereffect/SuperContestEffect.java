package com.xeroxparc.pokedex.data.model.contest.supereffect;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.APIResource;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;

import java.util.List;

/**
 * Super contest effects refer to the effects of moves when used in super contests.
 * 
 * @author Fabio Buracchi
 */
public class SuperContestEffect extends APIResource {

	// The level of appeal this super contest effect has.
	@SerializedName("appeal")
	private Integer appeal;

	// The flavor text of this super contest effect listed in different languages.
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;

	// A list of moves that have the effect when used in super contests.
	@SerializedName("moves")
	private List<Move> moveList;

}
