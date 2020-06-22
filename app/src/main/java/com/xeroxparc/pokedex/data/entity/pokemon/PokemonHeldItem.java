package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonHeldItem {

	@SerializedName("item")
	private NamedAPIResource itemResource;                  // The item the referenced Pokémon holds
															// (Item)

	@SerializedName("version_details")
	private List<PokemonHeldItemVersion> versionDetailList; // The details of the different versions
															// in which the item is held.

}
