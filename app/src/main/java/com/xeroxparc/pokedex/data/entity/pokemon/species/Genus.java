package com.xeroxparc.pokedex.data.entity.pokemon.species;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class Genus {

	@SerializedName("genus")
	private String genus;                           // The localized genus for the referenced
													// Pokémon species

	@SerializedName("language")
	private NamedAPIResource languageResource;      // The language this genus is in.
													// (Language)
}
