package com.xeroxparc.pokedex.data.database.dao.location;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.location.Location;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface LocationDao extends BaseDao<Location> {

	@Query("SELECT * FROM location WHERE location.id = (:id)")
	Location getLocation(int id);

}
