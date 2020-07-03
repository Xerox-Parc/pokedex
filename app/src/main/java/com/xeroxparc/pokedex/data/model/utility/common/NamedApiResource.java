package com.xeroxparc.pokedex.data.model.utility.common;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
@Entity
public class NamedApiResource extends ApiResource {

	// The name of the referenced resource.
	@ColumnInfo(name = "name")
	@SerializedName("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
