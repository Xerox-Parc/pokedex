package com.xeroxparc.pokedex.data.model.utility.common;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.machine.Machine;

/**
 * @author Fabio Buracchi
 */
public class MachineVersionDetail {

	// The machine that teaches a move from an item.
	@SerializedName("machine")
	private Machine machine;

	// The version group of this specific machine.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

}
