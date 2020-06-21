package com.xeroxparc.pokedex.data.entity.contest.effect;

import com.xeroxparc.pokedex.data.entity.utility.common.Effect;
import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;

import java.util.List;

public class ContestEffect {

	//Contest effects refer to the effects of moves when used in contests.

	private Integer id;                             //The identifier for this resource.
	private Integer appeal;                         //The base number of hearts the user of this move gets.
	private Integer jam;                            //The base number of hearts the user's opponent loses.
	private List<Effect> effect_entries;            //The result of this contest effect listed in different languages.
	private List<FlavorText> flavor_text_entries;   //The flavor text of this contest effect listed in different languages.

}
