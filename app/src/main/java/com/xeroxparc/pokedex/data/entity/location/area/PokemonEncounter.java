package com.xeroxparc.pokedex.data.entity.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VersionEncounterDetail;

import java.util.List;

public class PokemonEncounter {

	@SerializedName("pokemon")
	private NamedAPIResource pokemonResource;                   //The Pokémon being encountered.
																// (Pokemon)

	@SerializedName("version_details")
	private List<VersionEncounterDetail> versionDetailsList;    //A list of versions and encounters
																// with Pokémon that might happen in
																// the referenced location area.

}
