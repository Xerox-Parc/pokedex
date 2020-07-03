package com.xeroxparc.pokedex.data.database.dao.move;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MoveDamageClassDao extends BaseDao<MoveDamageClass> {

	@Query("SELECT * FROM move_damage_class WHERE move_damage_class.id = (:id)")
	MoveDamageClass getMoveDamageClass(int id);

}
