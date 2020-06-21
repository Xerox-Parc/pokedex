package com.xeroxparc.pokedex.data.entity.contest.effectsuper;

import com.xeroxparc.pokedex.data.entity.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class SuperContestEffect {

	//Super contest effects refer to the effects of moves when used in super contests.

	private Integer id;                             //The identifier for this resource.
	private Integer appeal;                         //The identifier for this resource.
	private List<FlavorText> flavor_text_entries;   //The identifier for this resource.
	private List<NamedAPIResource> moves;           //The identifier for this resource. (Move)

}
