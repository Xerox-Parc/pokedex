package com.xeroxparc.pokedex.data.entity.contest.effect;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Effect;
import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;

import java.util.List;

public class ContestEffect {

	/*
		Contest effects refer to the effects of moves when used in contests.
	 */

	@SerializedName("id")
	private Integer id;                             // The identifier for this resource.

	@SerializedName("appeal")
	private Integer appeal;                         // The base number of hearts the user of this
													// move gets.

	@SerializedName("jam")
	private Integer jam;                            // The base number of hearts the user's opponent
													// loses.

	@SerializedName("effect_entries")
	private List<Effect> effectList;                // The result of this contest effect listed in
													// different languages.

	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;        // The flavor text of this contest effect listed
													// in different languages.

}
