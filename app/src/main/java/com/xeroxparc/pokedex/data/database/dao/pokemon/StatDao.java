package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface StatDao extends BaseDao<Stat> {

	@Query("SELECT * FROM stat WHERE stat.id = (:id)")
	Stat getStat(int id);

}
