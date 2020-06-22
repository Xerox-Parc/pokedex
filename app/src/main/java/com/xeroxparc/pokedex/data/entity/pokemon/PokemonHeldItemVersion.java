package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class PokemonHeldItemVersion {

	@SerializedName("version")
	private NamedAPIResource versionResource;       // The version in which the item is held.
													// (Version)

	@SerializedName("rarity")
	private Integer rarity;                         // How often the item is held.

}
