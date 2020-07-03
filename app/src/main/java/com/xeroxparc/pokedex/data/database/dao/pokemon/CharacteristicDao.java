package com.xeroxparc.pokedex.data.database.dao.pokemon;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.pokemon.characteristic.Characteristic;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface CharacteristicDao extends BaseDao<Characteristic> {

	@Query("SELECT * FROM characteristic WHERE characteristic.id = (:id)")
	Characteristic getCharacteristic(int id);

}
