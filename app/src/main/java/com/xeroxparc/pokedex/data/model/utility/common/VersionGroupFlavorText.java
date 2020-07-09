package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
public class VersionGroupFlavorText {

	// The localized name for an API resource in a specific language.
	@SerializedName("text")
	private String text;

	// The language this name is in.
	@SerializedName("language")
	private Language language;

	// The version group which uses this flavor text.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	public String getText() {
		return text;
	}

	public Language getLanguage() {
		return language;
	}

	public VersionGroup getVersionGroup() {
		return versionGroup;
	}

}
