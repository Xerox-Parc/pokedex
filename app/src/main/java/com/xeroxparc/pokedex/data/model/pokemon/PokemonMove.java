package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.move.Move;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class PokemonMove {

	// The move the Pokémon can learn.
	@SerializedName("move")
	private Move move;

	// The details of the version in which the Pokémon can learn the move.
	@SerializedName("version_group_details")
	private List<PokemonMoveVersion> versionGroupDetailList;

}
