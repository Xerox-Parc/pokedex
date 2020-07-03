package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.target.MoveTarget;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveTargetDao extends BaseDao<MoveTarget> {

	@Query("SELECT * FROM move_target WHERE move_target.id = (:id)")
	MoveTarget getMoveTarget(int id);

}
