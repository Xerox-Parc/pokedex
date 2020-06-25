package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class Description {

	@SerializedName("description")
	private String text;                            // The localized description for an API resource
													// in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;      // The language this name is in.
													// (Language)

}
