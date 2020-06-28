package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;

/**
 * @author Fabio Buracchi
 */
public class PokemonHeldItemVersion {

	// The version in which the item is held.
	@SerializedName("version")
	private Version version;

	// How often the item is held.
	@SerializedName("rarity")
	private Integer rarity;

}
