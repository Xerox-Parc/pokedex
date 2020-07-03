package com.xeroxparc.pokedex.data.database.dao.encounter;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.encounter.method.EncounterMethod;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EncounterMethodDao extends BaseDao<EncounterMethod> {

	@Query("SELECT * FROM encounter_method WHERE encounter_method.id = (:id)")
	EncounterMethod getEncounterMethod(int id);

}
