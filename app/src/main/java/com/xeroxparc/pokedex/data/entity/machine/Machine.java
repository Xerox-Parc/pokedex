package com.xeroxparc.pokedex.data.entity.machine;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;


public class Machine {

	//Machines are the representation of items that teach moves to Pokémon. They vary from version to version, so it is not certain that one specific TM or HM corresponds to a single Machine.

	private Integer id;                         //The identifier for this resource.
	private NamedAPIResource item;              //The name for this resource. (Item)
	private NamedAPIResource move;              //A list of locations that can be found in this region. (Move)
	private NamedAPIResource version_groups;    //A list of version groups where this region can be visited. (VersionGroup)

}
