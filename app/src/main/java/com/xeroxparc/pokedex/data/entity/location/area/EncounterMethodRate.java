package com.xeroxparc.pokedex.data.entity.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class EncounterMethodRate {

	@SerializedName("encounter_method")
	private NamedAPIResource encounterMethodResource;           // The method in which Pokémon may
																// be encountered in an area.
																// (EncounterMethod)

	@SerializedName("version_details")
	private List<EncounterVersionDetails> versionDetailsList;   // The chance of the encounter to
																// occur on a version of the game.

}
