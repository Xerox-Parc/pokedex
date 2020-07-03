package com.xeroxparc.pokedex.data.database.dao.item;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.item.attribute.ItemAttribute;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ItemAttributeDao extends BaseDao<ItemAttribute> {

	@Query("SELECT * FROM item_attribute WHERE item_attribute.id = (:id)")
	ItemAttribute getItemAttribute(int id);

}
