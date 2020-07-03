package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.form.PokemonForm;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface PokemonFormDao extends BaseDao<PokemonForm> {

	@Query("SELECT * FROM pokemon_form WHERE pokemon_form.id = (:id)")
	PokemonForm getPokemonForm(int id);

}
