package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class Name {

	@SerializedName("name")
	private String text;                                // The localized name for an API resource in
														// a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this name is in.
														// (Language)

}
