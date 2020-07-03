package com.xeroxparc.pokedex.data.model.encounter.condition;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Conditions which affect what pokemon might appear in the wild, e.g., day or night.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "encounter_condition")
public class EncounterCondition extends NamedApiResource {

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of possible values for this encounter condition.
	@ColumnInfo(name = "values_data")
	@SerializedName("values")
	private List<EncounterConditionValue> valueList;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<EncounterConditionValue> getValueList() {
		return valueList;
	}

	public void setValueList(List<EncounterConditionValue> valueList) {
		this.valueList = valueList;
	}

}
