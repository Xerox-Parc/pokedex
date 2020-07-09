package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonDao extends BaseDao<Pokemon> {

	@Query("SELECT * FROM pokemon WHERE pokemon.id = (:id)")
	Pokemon getPokemon(int id);

	@Query("SELECT * FROM pokemon")
	DataSource.Factory<Integer, Pokemon> getPagedList();

}
