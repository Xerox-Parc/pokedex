package com.xeroxparc.pokedex.data.model.contest.effect;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.ApiResource;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;

import java.util.List;

/**
 * Contest effects refer to the effects of moves when used in contests.
 *
 * @author Fabio Buracchi
 */
public class ContestEffect extends ApiResource {

	// The base number of hearts the user of this move gets.
	@SerializedName("appeal")
	private Integer appeal;

	// The base number of hearts the user's opponent loses.
	@SerializedName("jam")
	private Integer jam;

	// The result of this contest effect listed in different languages.
	@SerializedName("effect_entries")
	private List<Effect> effectList;

	// The flavor text of this contest effect listed in different languages.
	@SerializedName("flavor_text_entries")
	private List<FlavorText> flavorTextList;

}
