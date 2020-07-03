package com.xeroxparc.pokedex.data.model.location.area;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

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
@Entity(tableName = "location_area")
public class LocationArea extends NamedApiResource {

	// The internal id of an API resource within game data.
	@ColumnInfo(name = "game_index")
	@SerializedName("game_index")
	private Integer gameIndex;

	// A list of methods in which Pokémon may be encountered in this area and how likely the method will occur depending on the version of the game.
	@ColumnInfo(name = "encounter_method_rates_data")
	@SerializedName("encounter_method_rates")
	private List<EncounterMethodRate> encounterMethodRateList;

	// The region this location area can be found in.
	@ColumnInfo(name = "location_data")
	@SerializedName("location")
	private Location location;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of Pokémon that can be encountered in this area along with version specific details about the encounter.
	@ColumnInfo(name = "pokemon_encounters_data")
	@SerializedName("pokemon_encounters")
	private List<PokemonEncounter> pokemonEncounterList;

	public Integer getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(Integer gameIndex) {
		this.gameIndex = gameIndex;
	}

	public List<EncounterMethodRate> getEncounterMethodRateList() {
		return encounterMethodRateList;
	}

	public void setEncounterMethodRateList(List<EncounterMethodRate> encounterMethodRateList) {
		this.encounterMethodRateList = encounterMethodRateList;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PokemonEncounter> getPokemonEncounterList() {
		return pokemonEncounterList;
	}

	public void setPokemonEncounterList(List<PokemonEncounter> pokemonEncounterList) {
		this.pokemonEncounterList = pokemonEncounterList;
	}

}
