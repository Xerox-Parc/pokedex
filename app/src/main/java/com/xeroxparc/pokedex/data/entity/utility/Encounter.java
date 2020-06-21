package com.xeroxparc.pokedex.data.entity.utility;

import java.util.List;

public class Encounter {

	private Integer min_level;                          //The lowest level the Pokémon could be encountered at.
	private Integer max_level;                          //The highest level the Pokémon could be encountered at.
	private List<NamedAPIResource> condition_values;    //A list of condition values that must be in effect for this encounter to occur. (List<EncounterConditionValue>)
	private Integer chance;                             //Percent chance that this encounter will occur.
	private NamedAPIResource method;                    //The method by which this encounter happens. (EncounterMethod)

}
