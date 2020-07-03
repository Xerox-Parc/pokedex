package com.xeroxparc.pokedex.data.database.dao.machine;

import androidx.room.Dao;
import androidx.room.Query;

import com.xeroxparc.pokedex.data.database.dao.BaseDao;
import com.xeroxparc.pokedex.data.model.machine.Machine;

/**
 * @author Fabio Buracchi
 */
@Dao
public interface MachineDao extends BaseDao<Machine> {

	@Query("SELECT * FROM machine WHERE machine.id = (:id)")
	Machine getMachine(int id);

}
