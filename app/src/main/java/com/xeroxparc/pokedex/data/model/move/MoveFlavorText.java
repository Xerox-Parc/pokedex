package com.xeroxparc.pokedex.data.model.move;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class MoveFlavorText {

	// The localized flavor text for an api resource in a specific language.
	@SerializedName("flavor_text")
	private String flavorText;

	// The language this name is in.
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
