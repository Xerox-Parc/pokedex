package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;

/**
 * @author Fabio Buracchi
 */
public class PokemonMoveVersion {

	// The method by which the move is learned.
	@SerializedName("move_learn_method")
	private MoveLearnMethod moveLearnMethod;

	// The version group in which the move is learned.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	// The minimum level to learn the move.
	@SerializedName("level_learned_at")
	private Integer levelLearnedAt;

}
