package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonSpeciesDao extends BaseDao<PokemonSpecies> {

	@Query("SELECT * FROM pokemon_species WHERE pokemon_species.id = (:id)")
	PokemonSpecies getPokemonSpecies(int id);

}
