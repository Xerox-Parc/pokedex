package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.shape.PokemonShape;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonShapeDao extends BaseDao<PokemonShape> {

	@Query("SELECT * FROM pokemon_shape WHERE pokemon_shape.id = (:id)")
	PokemonShape getPokemonShape(int id);

}
