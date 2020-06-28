package com.xeroxparc.pokedex.data.model.location.area;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Location areas are sections of areas, such as floors in a building or cave. Each area has
 * its own set of possible Pokémon encounters.
 * 	
 * @author Fabio Buracchi
 */
public class LocationArea extends NamedApiResource {

	// The internal id of an API resource within game data.
	@SerializedName("game_index")
	private Integer gameIndex;

	// A list of methods in which Pokémon may be encountered in this area and how likely the method will occur depending on the version of the game.
	@SerializedName("encounter_method_rates")
	private List<EncounterMethodRate> encounterMethodRateList;

	// The region this location area can be found in.
	@SerializedName("location")
	private Location location;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of Pokémon that can be encountered in this area along with version specific details about the encounter.
	@SerializedName("pokemon_encounters")
	private List<PokemonEncounter> pokemonEncounterList;

}
