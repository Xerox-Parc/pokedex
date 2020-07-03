package com.xeroxparc.pokedex.data.database.dao.encounter;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EncounterConditionValueDao extends BaseDao<EncounterConditionValue> {

	@Query("SELECT * FROM encounter_condition_value WHERE encounter_condition_value.id = (:id)")
	EncounterConditionValue getEncounterConditionValue(int id);

}
