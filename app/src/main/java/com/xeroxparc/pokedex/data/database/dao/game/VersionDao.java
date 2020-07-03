package com.xeroxparc.pokedex.data.database.dao.game;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.game.version.Version;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface VersionDao extends BaseDao<Version> {

	@Query("SELECT * FROM version WHERE version.id = (:id)")
	Version getVersion(int id);

}
