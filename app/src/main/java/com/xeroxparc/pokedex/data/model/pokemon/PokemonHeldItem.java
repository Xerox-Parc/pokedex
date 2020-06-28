package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.item.Item;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class PokemonHeldItem {

	// The item the referenced Pokémon holds
	@SerializedName("item")
	private Item item;

	// The details of the different versions in which the item is held.
	@SerializedName("version_details")
	private List<PokemonHeldItemVersion> versionDetailList;

}
