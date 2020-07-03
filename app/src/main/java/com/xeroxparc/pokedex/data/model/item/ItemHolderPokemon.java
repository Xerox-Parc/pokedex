package com.xeroxparc.pokedex.data.model.item;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class ItemHolderPokemon {

	// The Pokémon that holds this item.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	// The details for the version that this item is held in by the Pokémon.
	@SerializedName("version_details")
	private List<ItemHolderPokemonVersionDetail> versionDetailList;

	public Pokemon getPokemon() {
		return pokemon;
	}

	public List<ItemHolderPokemonVersionDetail> getVersionDetailList() {
		return versionDetailList;
	}

}
