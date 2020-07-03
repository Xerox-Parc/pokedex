package com.xeroxparc.pokedex.data.database.dao.game;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokedexDao extends BaseDao<Pokedex> {

	@Query("SELECT * FROM pokedex WHERE pokedex.id = (:id)")
	Pokedex getPokedex(int id);

}
