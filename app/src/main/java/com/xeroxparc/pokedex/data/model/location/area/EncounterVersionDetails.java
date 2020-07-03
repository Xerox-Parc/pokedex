package com.xeroxparc.pokedex.data.model.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;

/**
 * @author Fabio Buracchi
 */
public class EncounterVersionDetails {

	// The chance of an encounter to occur.
	@SerializedName("rate")
	private Integer rate;

	// The version of the game in which the encounter can occur with the given chance.
	@SerializedName("version")
	private Version version;

	public Integer getRate() {
		return rate;
	}

	public Version getVersion() {
		return version;
	}

}
