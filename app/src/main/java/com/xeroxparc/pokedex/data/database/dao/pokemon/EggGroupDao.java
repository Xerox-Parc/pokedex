package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface EggGroupDao extends BaseDao<EggGroup> {

	@Query("SELECT * FROM egg_group WHERE egg_group.id = (:id)")
	EggGroup getEggGroup(int id);

}
