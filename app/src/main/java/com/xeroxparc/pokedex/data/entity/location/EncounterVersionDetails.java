package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

public class EncounterVersionDetails {

	private Integer rate;              //The chance of an encounter to occur.
	private NamedAPIResource version;  //The version of the game in which the encounter can occur with the given chance. (Version)

}
