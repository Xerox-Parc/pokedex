package com.xeroxparc.pokedex.data.model.location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Locations that can be visited within the games. Locations make up sizable portions of
 * regions, like cities or routes.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "location")
public class Location extends NamedApiResource {

	// The region this location can be found in.
	@ColumnInfo(name = "region_data")
	@SerializedName("region")
	private Region region;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of game indices relevent to this location by generation.
	@ColumnInfo(name = "game_indices_data")
	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;

	// Areas that can be found within this location.
	@ColumnInfo(name = "areas_data")
	@SerializedName("areas")
	private List<LocationArea> areaList;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<GenerationGameIndex> getGameIndexList() {
		return gameIndexList;
	}

	public void setGameIndexList(List<GenerationGameIndex> gameIndexList) {
		this.gameIndexList = gameIndexList;
	}

	public List<LocationArea> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<LocationArea> areaList) {
		this.areaList = areaList;
	}

}
