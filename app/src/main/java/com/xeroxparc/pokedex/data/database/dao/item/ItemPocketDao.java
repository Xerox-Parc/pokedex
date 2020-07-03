package com.xeroxparc.pokedex.data.database.dao.item;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.item.pocket.ItemPocket;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ItemPocketDao extends BaseDao<ItemPocket> {

	@Query("SELECT * FROM item_pocket WHERE item_pocket.id = (:id)")
	ItemPocket getItemPocket(int id);

}
