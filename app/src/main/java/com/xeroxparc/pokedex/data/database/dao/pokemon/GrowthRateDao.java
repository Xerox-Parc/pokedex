package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.growthrate.GrowthRate;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface GrowthRateDao extends BaseDao<GrowthRate> {

	@Query("SELECT * FROM growth_rate WHERE growth_rate.id = (:id)")
	GrowthRate getGrowthRate(int id);

}
