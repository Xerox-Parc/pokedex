package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class VersionEncounterDetail {

	// The game version this encounter happens in.
	@SerializedName("version")
	private Version version;

	// The total percentage of all encounter potential.
	@SerializedName("max_chance")
	private Integer maxChance;

	// A list of encounters and their specifics.
	@SerializedName("encounter_details")
	private List<Encounter> encounterDetailList;

	public Version getVersion() {
		return version;
	}

	public Integer getMaxChance() {
		return maxChance;
	}

	public List<Encounter> getEncounterDetailList() {
		return encounterDetailList;
	}

}
