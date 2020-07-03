package com.xeroxparc.pokedex.data.database.dao.item;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.item.effect.ItemFlingEffect;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ItemFlingEffectDao extends BaseDao<ItemFlingEffect> {

	@Query("SELECT * FROM item_fling_effect WHERE item_fling_effect.id = (:id)")
	ItemFlingEffect getItemFlingEffect(int id);

}
