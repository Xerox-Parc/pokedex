package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class FlavorText {

	@SerializedName("flavor_text")
	private String flavorText;                          // The localized flavor text for an API
														// resource in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this name is in.
														// (Language)

	@SerializedName("version")
	private NamedAPIResource versionResource;           // The game version this flavor text is
														// extracted from.
														// (Version)

}
