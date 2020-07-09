package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class Description {

	// The localized description for an API resource in a specific language.
	@SerializedName("description")
	private String text;

	// The language this name is in.
	@SerializedName("language")
	private Language language;

	public String getText() {
		return text;
	}

	public Language getLanguage() {
		return language;
	}

}
