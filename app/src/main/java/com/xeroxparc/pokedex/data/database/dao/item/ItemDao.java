package com.xeroxparc.pokedex.data.database.dao.item;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.item.Item;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ItemDao extends BaseDao<Item> {

	@Query("SELECT * FROM item WHERE item.id = (:id)")
	Item getItem(int id);

}
