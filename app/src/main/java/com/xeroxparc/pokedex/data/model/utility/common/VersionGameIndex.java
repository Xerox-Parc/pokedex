package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.version.Version;

/**
 * @author Fabio Buracchi
 */
public class VersionGameIndex {

	// The internal id of an API resource within game data.
	@SerializedName("game_index")
	private Integer gameIndex;

	// The version relevant to this game index.
	@SerializedName("version")
	private Version version;

	public Integer getGameIndex() {
		return gameIndex;
	}

	public Version getVersion() {
		return version;
	}

}
