package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class Effect {

	@SerializedName("effect")
	private String text;                            // The localized effect text for an API resource
													// in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;      // The language this effect is in.
													// (Language)

}
