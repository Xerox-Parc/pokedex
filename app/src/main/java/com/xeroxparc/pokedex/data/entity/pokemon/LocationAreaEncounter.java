package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VersionEncounterDetail;

import java.util.List;

public class LocationAreaEncounter {

	@SerializedName("location_area")
	private NamedAPIResource locationAreaResource;              // The location area the referenced
																// Pokémon can be encountered in.
																// (LocationArea)

	@SerializedName("version_details")
	private List<VersionEncounterDetail> versionDetailList;     // A list of versions and encounters
																// with the referenced Pokémon that
																// might happen.

}
