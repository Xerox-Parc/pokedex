package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface TypeDao extends BaseDao<Type> {

	@Query("SELECT * FROM type WHERE type.id = (:id)")
	Type getType(int id);

}
