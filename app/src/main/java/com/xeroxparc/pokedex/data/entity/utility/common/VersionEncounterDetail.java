package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VersionEncounterDetail {

	@SerializedName("version")
	private NamedAPIResource versionResource;           // The game version this encounter happens in
														// (Version)

	@SerializedName("max_chance")
	private Integer maxChance;                          // The total percentage of all encounter
														// potential.

	@SerializedName("encounter_details")
	private List<Encounter> encounterDetailResource;    // A list of encounters and their specifics.

}
