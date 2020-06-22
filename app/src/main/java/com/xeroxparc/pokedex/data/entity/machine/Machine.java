package com.xeroxparc.pokedex.data.entity.machine;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;


public class Machine {

	/*
		Machines are the representation of items that teach moves to Pokémon. They vary from version
		to version, so it is not certain that one specific TM or HM corresponds to a single Machine.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("item")
	private NamedAPIResource itemResource;              // The TM or HM item that corresponds to
														// this machine.
														// (Item)

	@SerializedName("move")
	private NamedAPIResource moveResource;              // The move that is taught by this machine.
														// (Move)

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group that this machine
														// applies to.
														// (VersionGroup)

}
