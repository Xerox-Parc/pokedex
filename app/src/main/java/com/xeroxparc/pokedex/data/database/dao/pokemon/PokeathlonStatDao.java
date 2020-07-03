package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats.PokeathlonStat;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokeathlonStatDao extends BaseDao<PokeathlonStat> {

	@Query("SELECT * FROM pokeathlon_stat WHERE pokeathlon_stat.id = (:id)")
	PokeathlonStat getPokeathlonStat(int id);

}
