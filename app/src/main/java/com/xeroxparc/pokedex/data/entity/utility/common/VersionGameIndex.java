package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class VersionGameIndex {

	@SerializedName("game_index")
	private Integer gameIndex;                      //The internal id of an API resource within
													// game data.

	@SerializedName("version")
	private NamedAPIResource versionResource;       //The version relevent to this game index.
													// (Version)

}
