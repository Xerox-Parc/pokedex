package com.xeroxparc.pokedex.data.database.dao.location;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.location.palparckarea.PalParkArea;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PalParkAreaDao extends BaseDao<PalParkArea> {

	@Query("SELECT * FROM pal_park_area WHERE pal_park_area.id = (:id)")
	PalParkArea getPalParkArea(int id);

}
