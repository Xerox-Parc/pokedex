package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class VersionGroupFlavorText {

	@SerializedName("text")
	private String text;                                // The localized name for an API resource
														// in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this name is in.
														// (Language)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group which uses this
														// flavor text.
														// (VersionGroup)

}
