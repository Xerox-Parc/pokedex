package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonMove {

	private NamedAPIResource version;                           //The move the Pokémon can learn. (Move)
	private List<PokemonMoveVersion> version_group_details;     //The details of the version in which the Pokémon can learn the move.

}
