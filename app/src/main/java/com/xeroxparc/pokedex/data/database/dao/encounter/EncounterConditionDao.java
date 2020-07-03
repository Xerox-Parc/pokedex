package com.xeroxparc.pokedex.data.database.dao.encounter;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.encounter.condition.EncounterCondition;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EncounterConditionDao extends BaseDao<EncounterCondition> {

	@Query("SELECT * FROM encounter_condition WHERE encounter_condition.id = (:id)")
	EncounterCondition getEncounterCondition(int id);

}
