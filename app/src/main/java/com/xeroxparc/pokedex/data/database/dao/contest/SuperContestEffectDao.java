package com.xeroxparc.pokedex.data.database.dao.contest;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.contest.supereffect.SuperContestEffect;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface SuperContestEffectDao extends BaseDao<SuperContestEffect> {

	@Query("SELECT * FROM super_contest_effect WHERE super_contest_effect.id = (:id)")
	SuperContestEffect getSuperContestEffect(int id);

}
