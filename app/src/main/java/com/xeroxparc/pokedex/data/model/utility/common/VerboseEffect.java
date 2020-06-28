package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class VerboseEffect {

	// The localized effect text for an API resource in a specific language.
	@SerializedName("effect")
	private String effect;

	// The localized effect text in brief.
	@SerializedName("short_effect")
	private String shortEffect;

	// The language this effect is in.
	@SerializedName("language")
	private Language language;

}
