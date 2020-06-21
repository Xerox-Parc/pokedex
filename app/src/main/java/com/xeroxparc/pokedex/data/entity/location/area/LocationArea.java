package com.xeroxparc.pokedex.data.entity.location.area;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class LocationArea {

	//Location areas are sections of areas, such as floors in a building or cave. Each area has its own set of possible Pokémon encounters.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private Integer game_index;                                 //The internal id of an API resource within game data.
	private List<EncounterMethodRate> encounter_method_rates;   //A list of methods in which Pokémon may be encountered in this area and how likely the method will occur depending on the version of the game.
	private NamedAPIResource location;                          //The region this location area can be found in. (Location)
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private List<PokemonEncounter> pokemon_encounters;          //A list of Pokémon that can be encountered in this area along with version specific details about the encounter.

}
