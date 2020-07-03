package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.gender.Gender;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface GenderDao extends BaseDao<Gender> {

	@Query("SELECT * FROM gender WHERE gender.id = (:id)")
	Gender getGender(int id);

}
