package com.xeroxparc.pokedex.data.database.dao.game;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface VersionGroupDao extends BaseDao<VersionGroup> {

	@Query("SELECT * FROM version_group WHERE version_group.id = (:id)")
	VersionGroup getVersionGroup(int id);

}
