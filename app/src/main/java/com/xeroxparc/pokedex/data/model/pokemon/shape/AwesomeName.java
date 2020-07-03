package com.xeroxparc.pokedex.data.model.pokemon.shape;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class AwesomeName {

	// The localized "scientific" name for an API resource in a specific language.
	@SerializedName("awesome_name")
	private String name;

	// The language this "scientific" name is in.
	@SerializedName("language")
	private Language language;

	public String getName() {
		return name;
	}

	public Language getLanguage() {
		return language;
	}
}
