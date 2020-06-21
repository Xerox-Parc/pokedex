package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class PokemonHeldItem {

	private NamedAPIResource item;                          //The item the referenced Pokémon holds. (Item)
	private List<PokemonHeldItemVersion> version_details;   //The details of the different versions in which the item is held.

}
