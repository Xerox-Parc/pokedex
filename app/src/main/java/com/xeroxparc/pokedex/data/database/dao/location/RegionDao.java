package com.xeroxparc.pokedex.data.database.dao.location;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.location.region.Region;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface RegionDao extends BaseDao<Region> {

	@Query("SELECT * FROM region WHERE region.id = (:id)")
	Region getRegion(int id);

}
