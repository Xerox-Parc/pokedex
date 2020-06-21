package com.xeroxparc.pokedex.data.entity.location;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

import java.util.List;

public class EncounterMethodRate {

	private NamedAPIResource encounter_method;              //The identifier for this resource. (EncounterMethod)
	private List<EncounterVersionDetails> version_details;  //The chance of the encounter to occur on a version of the game.

}
