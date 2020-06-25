package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class VerboseEffect {

	@SerializedName("effect")
	private String effect;                              // The localized effect text for an API
														// resource in a specific language.

	@SerializedName("short_effect")
	private String shortEffect;                         // The localized effect text in brief.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this effect is in.
														// (Language)

}
