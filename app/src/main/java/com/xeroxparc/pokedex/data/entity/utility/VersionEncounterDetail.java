package com.xeroxparc.pokedex.data.entity.utility;

import java.util.List;

public class VersionEncounterDetail {

	private NamedAPIResource version;           //The game version this encounter happens in. (Version)
	private Integer max_chance;                 //The total percentage of all encounter potential.
	private List<Encounter> encounter_details;  //A list of encounters and their specifics.

}
