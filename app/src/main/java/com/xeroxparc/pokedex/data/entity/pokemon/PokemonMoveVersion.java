package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

public class PokemonMoveVersion {

	private NamedAPIResource move_learn_method;     //The method by which the move is learned. (MoveLearnMethod)
	private NamedAPIResource version_group;         //The version group in which the move is learned. (VersionGroup)
	private Integer level_learned_at;               //The minimum level to learn the move.

}
