package com.xeroxparc.pokedex.data.database.dao.berry;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.berry.Berry;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface BerryDao extends BaseDao<Berry> {

	@Query("SELECT * FROM berry WHERE berry.id = (:id)")
	Berry getBerry(int id);

}
