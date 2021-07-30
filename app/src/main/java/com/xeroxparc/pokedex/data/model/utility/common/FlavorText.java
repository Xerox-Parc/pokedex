package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class FlavorText {

	// The localized flavor text for an API resource in a specific language.
	@SerializedName("flavor_text")
	private String text;

	// The language this name is in.
	@SerializedName("language")
	private Language language;

	// The game version this flavor text is extracted from.
	@SerializedName("version")
	private Version version;

	public String getText() {
		return text;
	}

	public Language getLanguage() {
		return language;
	}

	public Version getVersion() {
		return version;
	}

}
