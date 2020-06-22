package com.xeroxparc.pokedex.data.entity.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class MoveFlavorText {

	@SerializedName("flavor_text")
	private String flavorText;                          // The localized flavor text for an api
														// resource in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this name is in.
														// (Language)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group that uses this flavor
														// text.
														// (VersionGroup)

}
