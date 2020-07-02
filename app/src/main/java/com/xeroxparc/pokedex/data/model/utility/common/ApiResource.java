package com.xeroxparc.pokedex.data.model.utility.common;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
@Entity
public class ApiResource {

	//The identifier for this resource
	@PrimaryKey
	@SerializedName("id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
