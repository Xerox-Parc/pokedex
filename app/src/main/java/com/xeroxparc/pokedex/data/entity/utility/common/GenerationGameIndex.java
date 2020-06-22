package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class GenerationGameIndex {

	@SerializedName("game_index")
	private Integer gameIndex;                      // The internal id of an API resource within
													// game data.

	@SerializedName("generation")
	private NamedAPIResource generationResource;    // The generation relevent to this game index.
													// (Generation)

}
