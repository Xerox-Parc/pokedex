package com.xeroxparc.pokedex.data.database.dao.evolution;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.evolution.trigger.EvolutionTrigger;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EvolutionTriggerDao extends BaseDao<EvolutionTrigger> {

	@Query("SELECT * FROM evolution_trigger WHERE evolution_trigger.id = (:id)")
	EvolutionTrigger getEvolutionTrigger(int id);

}
