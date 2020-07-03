package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.ailment.MoveAilment;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveAilmentDao extends BaseDao<MoveAilment> {

	@Query("SELECT * FROM move_ailment WHERE move_ailment.id = (:id)")
	MoveAilment getMoveAilment(int id);

}
