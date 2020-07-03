package com.xeroxparc.pokedex.data.database.dao.utility;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.utility.language.Language;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface LanguageDao extends BaseDao<Language> {

	@Query("SELECT * FROM language WHERE language.id = (:id)")
	Language getLanguage(int id);

}
