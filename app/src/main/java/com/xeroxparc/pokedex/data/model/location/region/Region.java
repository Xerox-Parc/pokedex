package com.xeroxparc.pokedex.data.model.location.region;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A region is an organized area of the Pokémon world. Most often, the main difference between
 * regions is the species of Pokémon that can be encountered within them.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "region")
public class Region extends NamedApiResource {

	// A list of locations that can be found in this region.
	@ColumnInfo(name = "locations_data")
	@SerializedName("locations")
	private List<Location> locationList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// The generation this region was introduced in.
	@ColumnInfo(name = "main_generation_data")
	@SerializedName("main_generation")
	private Generation mainGeneration;

	// A list of pokédexes that catalogue Pokémon in this region.
	@ColumnInfo(name = "pokedexes_data")
	@SerializedName("pokedexes")
	private List<Pokedex> pokedexList;

	// A list of version groups where this region can be visited.
	@ColumnInfo(name = "version_groups_data")
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public Generation getMainGeneration() {
		return mainGeneration;
	}

	public void setMainGeneration(Generation mainGeneration) {
		this.mainGeneration = mainGeneration;
	}

	public List<Pokedex> getPokedexList() {
		return pokedexList;
	}

	public void setPokedexList(List<Pokedex> pokedexList) {
		this.pokedexList = pokedexList;
	}

	public List<VersionGroup> getVersionGroupList() {
		return versionGroupList;
	}

	public void setVersionGroupList(List<VersionGroup> versionGroupList) {
		this.versionGroupList = versionGroupList;
	}

}
