package com.xeroxparc.pokedex.data.database.dao.contest;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface ContestTypeDao extends BaseDao<ContestType> {

	@Query("SELECT * FROM contest_type WHERE contest_type.id = (:id)")
	ContestType getContestType(int id);

}
