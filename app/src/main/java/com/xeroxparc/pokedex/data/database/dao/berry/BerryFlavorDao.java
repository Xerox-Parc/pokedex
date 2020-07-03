package com.xeroxparc.pokedex.data.database.dao.berry;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface BerryFlavorDao extends BaseDao<BerryFlavor> {

	@Query("SELECT * FROM berry_flavor WHERE berry_flavor.id = (:id)")
	BerryFlavor getBerryFlavor(int id);

}
