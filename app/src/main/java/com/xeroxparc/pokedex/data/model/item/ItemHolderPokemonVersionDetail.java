package com.xeroxparc.pokedex.data.model.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;

/**
 * @author Fabio Buracchi
 */
public class ItemHolderPokemonVersionDetail {

	// How often this Pokémon holds this item in this version.
	@SerializedName("rarity")
	private Integer rarity;

	// The version that this item is held in by the Pokémon.
	@SerializedName("version")
	private Version version;

}
