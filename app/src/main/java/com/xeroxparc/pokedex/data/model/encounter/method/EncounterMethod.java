package com.xeroxparc.pokedex.data.model.encounter.method;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall
 * grass. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "encounter_method")
public class EncounterMethod extends NamedApiResource {

	// A good value for sorting.
	@SerializedName("order")
	private Integer order;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}