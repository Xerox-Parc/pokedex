package com.xeroxparc.pokedex.data.model.contest.type;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "contest_type")
public class ContestType extends NamedApiResource {

	// The berry flavor that correlates with this contest type.
	@ColumnInfo(name = "berry_flavor_data")
	@SerializedName("berry_flavor")
	private BerryFlavor berryFlavor;

	// The name of this contest type listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<ContestName> contestNameList;

	public BerryFlavor getBerryFlavor() {
		return berryFlavor;
	}

	public void setBerryFlavor(BerryFlavor berryFlavor) {
		this.berryFlavor = berryFlavor;
	}

	public List<ContestName> getContestNameList() {
		return contestNameList;
	}

	public void setContestNameList(List<ContestName> contestNameList) {
		this.contestNameList = contestNameList;
	}

}
