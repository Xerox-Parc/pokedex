package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;

/**
 * @author Fabio Buracchi
 */
public class GenerationGameIndex {

	// The internal id of an API resource within game data.
	@SerializedName("game_index")
	private Integer gameIndex;

	// The generation relevant to this game index.
	@SerializedName("generation")
	private Generation generation;

}
