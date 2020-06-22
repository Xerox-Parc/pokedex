package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class AbilityFlavorText {

	@SerializedName("flavor_text")
	private NamedAPIResource flavorTextResource;        // The localized name for an API resource
														// in a specific language.

	@SerializedName("language")
	private NamedAPIResource languageResource;          // The language this text resource is in.
														// (Language)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group that uses this flavor
														// text.
														// (VersionGroup)
}
