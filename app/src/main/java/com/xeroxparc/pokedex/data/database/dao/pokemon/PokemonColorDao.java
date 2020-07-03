package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.color.PokemonColor;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonColorDao extends BaseDao<PokemonColor> {

	@Query("SELECT * FROM pokemon_color WHERE pokemon_color.id = (:id)")
	PokemonColor getPokemonColor(int id);

}
