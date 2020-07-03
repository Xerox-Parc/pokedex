package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.battlestyle.MoveBattleStyle;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveBattleStyleDao extends BaseDao<MoveBattleStyle> {

	@Query("SELECT * FROM move_battle_style WHERE move_battle_style.id = (:id)")
	MoveBattleStyle getMoveBattleStyle(int id);

}
