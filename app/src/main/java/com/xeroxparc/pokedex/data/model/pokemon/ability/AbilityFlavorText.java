package com.xeroxparc.pokedex.data.model.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class AbilityFlavorText {

	// The localized name for an API resource in a specific language.
	@SerializedName("flavor_text")
	private String flavorText;

	// The language this text resource is in.
	@SerializedName("language")
	private Language language;

	// The version group that uses this flavor text.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	public String getFlavorText() {
		return flavorText;
	}

	public Language getLanguage() {
		return language;
	}

	public VersionGroup getVersionGroup() {
		return versionGroup;
	}

}
