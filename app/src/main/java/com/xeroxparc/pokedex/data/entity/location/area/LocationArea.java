package com.xeroxparc.pokedex.data.entity.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class LocationArea {

	/*
		Location areas are sections of areas, such as floors in a building or cave. Each area has
		its own set of possible Pokémon encounters.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("game_index")
	private Integer gameIndex;                                  // The internal id of an API
																// resource within game data.

	@SerializedName("encounter_method_rates")
	private List<EncounterMethodRate> encounterMethodRateList;  // A list of methods in which
																// Pokémon may be encountered in
																// this area and how likely the
																// method will occur depending on
																// the version of the game.

	@SerializedName("location")
	private NamedAPIResource locationResource;                  // The region this location area can
																// be found in.
																// (Location)

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_encounters")
	private List<PokemonEncounter> pokemonEncounterList;        // A list of Pokémon that can be
																// encountered in this area along
																// with version specific details
																// about the encounter.

}
