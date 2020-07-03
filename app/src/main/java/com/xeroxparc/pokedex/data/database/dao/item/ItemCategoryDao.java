package com.xeroxparc.pokedex.data.database.dao.item;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.item.category.ItemCategory;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ItemCategoryDao extends BaseDao<ItemCategory> {

	@Query("SELECT * FROM item_category WHERE item_category.id = (:id)")
	ItemCategory getItemCategory(int id);

}
