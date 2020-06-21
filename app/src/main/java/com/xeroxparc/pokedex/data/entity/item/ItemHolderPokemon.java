package com.xeroxparc.pokedex.data.entity.item;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemHolderPokemon {

	private NamedAPIResource pokemon;                               //The Pokémon that holds this item.
	private List<ItemHolderPokemonVersionDetail> version_details;   //The details for the version that this item is held in by the Pokémon.

}
