package com.xeroxparc.pokedex.data.model.berry.flavor;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on
 * their nature. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "berry_flavor")
public class BerryFlavor extends NamedApiResource {

	// A list of the berries with this flavor.
	@ColumnInfo(name = "berries_data")
	@SerializedName("berries")
	private List<FlavorBerryMap> flavorBerryMapList;

	// The contest type that correlates with this berry flavor.
	@ColumnInfo(name = "contest_type_data")
	@SerializedName("contest_type")
	private ContestType contestType;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public List<FlavorBerryMap> getFlavorBerryMapList() {
		return flavorBerryMapList;
	}

	public void setFlavorBerryMapList(List<FlavorBerryMap> flavorBerryMapList) {
		this.flavorBerryMapList = flavorBerryMapList;
	}

	public ContestType getContestType() {
		return contestType;
	}

	public void setContestType(ContestType contestType) {
		this.contestType = contestType;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
