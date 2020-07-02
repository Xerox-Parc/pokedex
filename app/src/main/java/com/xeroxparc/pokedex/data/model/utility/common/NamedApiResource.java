package com.xeroxparc.pokedex.data.model.utility.common;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
@Entity
public class NamedApiResource extends ApiResource {

	// The name of the referenced resource.
	@SerializedName("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
