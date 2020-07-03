package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.habitat.PokemonHabitat;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonHabitatDao extends BaseDao<PokemonHabitat> {

	@Query("SELECT * FROM pokemon_habitat WHERE pokemon_habitat.id = (:id)")
	PokemonHabitat getPokemonHabitat(int id);

}
