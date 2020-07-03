package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.Move;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveDao extends BaseDao<Move> {

	@Query("SELECT * FROM move WHERE move.id = (:id)")
	Move getMove(int id);

}
