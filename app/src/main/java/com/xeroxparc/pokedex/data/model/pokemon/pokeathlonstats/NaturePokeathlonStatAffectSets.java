package com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class NaturePokeathlonStatAffectSets {

	// A list of natures and how they change the referenced Pokéathlon stat.
	@SerializedName("increase")
	private List<NaturePokeathlonStatAffect> increaseStatList;

	// A list of natures and how they change the referenced Pokéathlon stat.
	@SerializedName("decrease")
	private List<NaturePokeathlonStatAffect> decreaseStatList;

	public List<NaturePokeathlonStatAffect> getIncreaseStatList() {
		return increaseStatList;
	}

	public List<NaturePokeathlonStatAffect> getDecreaseStatList() {
		return decreaseStatList;
	}

}
