package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.nature.Nature;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface NatureDao extends BaseDao<Nature> {

	@Query("SELECT * FROM nature WHERE nature.id = (:id)")
	Nature getNature(int id);

}
