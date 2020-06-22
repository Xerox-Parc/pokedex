package com.xeroxparc.pokedex.data.entity.contest.effectsuper;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class SuperContestEffect {

	/*
		Super contest effects refer to the effects of moves when used in super contests.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("appeal")
	private Integer appeal;                             // The level of appeal this super contest
														// effect has.

	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;            // The flavor text of this super contest
														// effect listed in different languages.

	@SerializedName("moves")
	private List<NamedAPIResource> moveListResource;    // A list of moves that have the effect when
														// used in super contests.
														// (Move)

}
