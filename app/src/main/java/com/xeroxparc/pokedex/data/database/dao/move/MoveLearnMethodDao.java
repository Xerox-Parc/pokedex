package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveLearnMethodDao extends BaseDao<MoveLearnMethod> {

	@Query("SELECT * FROM move_learn_method WHERE move_learn_method.id = (:id)")
	MoveLearnMethod getMoveLearnMethod(int id);

}
