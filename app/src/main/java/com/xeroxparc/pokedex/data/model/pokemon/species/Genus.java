package com.xeroxparc.pokedex.data.model.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class Genus {

	// The localized genus for the referenced Pokémon species
	@SerializedName("genus")
	private String name;

	// The language this genus is in.
	@SerializedName("language")
	private Language language;

	public String getName() {
		return name;
	}

	public Language getLanguage() {
		return language;
	}

}
