package com.xeroxparc.pokedex.data.database.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

/**
 * Base DAO interface
 *
 * @author Fabio Buracchi
 */
public interface BaseDao<T> {

	/**
	 * Insert an object in the database.
	 *
	 * @param object the object to be inserted.
	 */
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(T object);

	/**
	 * Insert an array of objects in the database.
	 *
	 * @param object the object to be inserted.
	 */
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(List<T> object);

	/**
	 * Update an object from the database.
	 *
	 * @param object the object to be updated
	 */
	@Update
	void update(T object);

	/**
	 * Delete an object from the database
	 *
	 * @param object the object to be deleted
	 */
	@Delete
	void delete(T object);

}
