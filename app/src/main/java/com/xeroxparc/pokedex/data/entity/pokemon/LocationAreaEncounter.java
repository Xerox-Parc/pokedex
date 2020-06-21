package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VersionEncounterDetail;

import java.util.List;

public class LocationAreaEncounter {

	private NamedAPIResource location_area;                 //The location area the referenced Pokémon can be encountered in. (LocationArea)
	private List<VersionEncounterDetail> version_details;   //A list of versions and encounters with the referenced Pokémon that might happen.

}
