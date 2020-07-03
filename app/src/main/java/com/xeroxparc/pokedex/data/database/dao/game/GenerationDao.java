package com.xeroxparc.pokedex.data.database.dao.game;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface GenerationDao extends BaseDao<Generation> {

	@Query("SELECT * FROM generation WHERE generation.id = (:id)")
	Generation getGeneration(int id);

}
