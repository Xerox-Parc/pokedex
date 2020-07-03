package com.xeroxparc.pokedex.data.database.dao.berry;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.berry.firmness.BerryFirmness;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface BerryFirmnessDao extends BaseDao<BerryFirmness> {

	@Query("SELECT * FROM berry_firmness WHERE berry_firmness.id = (:id)")
	BerryFirmness getBerryFirmness(int id);

}
