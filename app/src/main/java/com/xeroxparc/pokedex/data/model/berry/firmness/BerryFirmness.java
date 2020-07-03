package com.xeroxparc.pokedex.data.model.berry.firmness;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.Berry;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Berries can be soft or hard. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "berry_firmness")
public class BerryFirmness extends NamedApiResource {

	// A list of the berries with this firmness.
	@ColumnInfo(name = "berries_data")
	@SerializedName("berries")
	private List<Berry> berryList;

	//The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public List<Berry> getBerryList() {
		return berryList;
	}

	public void setBerryList(List<Berry> berryList) {
		this.berryList = berryList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
