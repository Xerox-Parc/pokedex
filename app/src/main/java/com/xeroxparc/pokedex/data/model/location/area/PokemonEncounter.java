package com.xeroxparc.pokedex.data.model.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.utility.common.VersionEncounterDetail;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class PokemonEncounter {

	//The Pokémon being encountered.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	//A list of versions and encounters with Pokémon that might happen in the referenced location area.
	@SerializedName("version_details")
	private List<VersionEncounterDetail> versionDetailList;

	public Pokemon getPokemon() {
		return pokemon;
	}

	public List<VersionEncounterDetail> getVersionDetailList() {
		return versionDetailList;
	}

}
