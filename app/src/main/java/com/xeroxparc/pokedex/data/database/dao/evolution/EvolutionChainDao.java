package com.xeroxparc.pokedex.data.database.dao.evolution;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.evolution.chain.EvolutionChain;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EvolutionChainDao extends BaseDao<EvolutionChain> {

	@Query("SELECT * FROM evolution_chain WHERE evolution_chain.id = (:id)")
	EvolutionChain getEvolutionChain(int id);

}
