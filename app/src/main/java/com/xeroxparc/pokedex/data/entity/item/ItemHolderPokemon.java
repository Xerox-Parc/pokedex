package com.xeroxparc.pokedex.data.entity.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class ItemHolderPokemon {

	@SerializedName("pokemon")
	private NamedAPIResource pokemon;                                   // The Pokémon that holds
																		// this item.

	@SerializedName("version_details")
	private List<ItemHolderPokemonVersionDetail> versionDetailList;     // The details for the
																		// version that this item is
																		// held in by the Pokémon.

}
