package com.xeroxparc.pokedex.data.database.dao.contest;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.contest.effect.ContestEffect;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ContestEffectDao extends BaseDao<ContestEffect> {

	@Query("SELECT * FROM contest_effect WHERE contest_effect.id = (:id)")
	ContestEffect getContestEffect(int id);

}
