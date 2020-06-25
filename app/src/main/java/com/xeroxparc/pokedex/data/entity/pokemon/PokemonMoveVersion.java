package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonMoveVersion {

	@SerializedName("move_learn_method")
	private NamedAPIResource moveLearnMethodResource;   // The method by which the move is learned.
														// (MoveLearnMethod)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group in which the move
														// is learned.
														// (VersionGroup)

	@SerializedName("level_learned_at")
	private Integer levelLearnedAt;                     // The minimum level to learn the move.

}
