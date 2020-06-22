package com.xeroxparc.pokedex.data.entity.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class ItemHolderPokemonVersionDetail {

	@SerializedName("rarity")
	private Integer rarity;             // How often this Pokémon holds this item in this version.

	@SerializedName("version")
	private NamedAPIResource version;   // The version that this item is held in by the Pokémon.
										// (Version)

}
