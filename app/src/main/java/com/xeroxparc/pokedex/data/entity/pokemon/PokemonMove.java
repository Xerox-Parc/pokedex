package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonMove {

	@SerializedName("move")
	private NamedAPIResource moveResource;                      // The move the Pokémon can learn.
																// (Move)

	@SerializedName("version_group_details")
	private List<PokemonMoveVersion> versionGroupDetailList;    // The details of the version in
																// which the Pokémon can learn the
																// move.

}
