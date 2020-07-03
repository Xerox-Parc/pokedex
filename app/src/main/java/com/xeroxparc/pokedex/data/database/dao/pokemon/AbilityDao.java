package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface AbilityDao extends BaseDao<Ability> {

	@Query("SELECT * FROM ability WHERE ability.id = (:id)")
	Ability getAbility(int id);

}
