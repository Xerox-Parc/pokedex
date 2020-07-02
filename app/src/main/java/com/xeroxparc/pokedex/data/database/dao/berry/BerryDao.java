package com.xeroxparc.pokedex.data.database.dao.berry;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.model.berry.Berry;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface BerryDao {

	@Query("SELECT * FROM berry WHERE id = (:id)")
	Berry getBerry(int id);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(Berry berry);

}
