package com.xeroxparc.pokedex.data.entity.utility.common;

import com.google.gson.annotations.SerializedName;

public class MachineVersionDetail {

	@SerializedName("machine")
	private APIResource machineResource;            // The machine that teaches a move from an item.
													// (Machine)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;  // The version group of this specific machine.
													// (VersionGroup)

}
