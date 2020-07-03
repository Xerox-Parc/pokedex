package com.xeroxparc.pokedex.data.database.dao.location;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface LocationAreaDao extends BaseDao<LocationArea> {

	@Query("SELECT * FROM location_area WHERE location_area.id = (:id)")
	LocationArea getLocationArea(int id);

}
