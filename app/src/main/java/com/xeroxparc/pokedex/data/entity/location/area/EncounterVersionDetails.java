package com.xeroxparc.pokedex.data.entity.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class EncounterVersionDetails {

	@SerializedName("rate")
	private Integer rate;                           // The chance of an encounter to occur.

	@SerializedName("version")
	private NamedAPIResource versionResource;       // The version of the game in which the
													// encounter can occur with the given chance.
													// (Version)

}
