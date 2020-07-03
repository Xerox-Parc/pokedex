package com.xeroxparc.pokedex.data.model.encounter.conditionvalue;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.condition.EncounterCondition;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Encounter condition values are the various states that an encounter condition can have,
 * i.e., time of day can be either day or night.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "encounter_condition_value")
public class EncounterConditionValue extends NamedApiResource {

	// The condition this encounter condition value pertains to.
	@ColumnInfo(name = "condition_data")
	@SerializedName("condition")
	private EncounterCondition condition;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	public EncounterCondition getCondition() {
		return condition;
	}

	public void setCondition(EncounterCondition condition) {
		this.condition = condition;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

}
