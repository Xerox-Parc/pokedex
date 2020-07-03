package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.categoty.MoveCategory;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveCategoryDao extends BaseDao<MoveCategory> {

	@Query("SELECT * FROM move_category WHERE move_category.id = (:id)")
	MoveCategory getMoveCategory(int id);

}
