package com.xeroxparc.pokedex.data.model.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.method.EncounterMethod;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class EncounterMethodRate {

	// The method in which Pokémon may be encountered in an area.
	@SerializedName("encounter_method")
	private EncounterMethod encounterMethod;

	// The chance of the encounter to occur on a version of the game.
	@SerializedName("version_details")
	private List<EncounterVersionDetails> versionDetailsList;

}
