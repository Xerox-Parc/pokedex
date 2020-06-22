package com.xeroxparc.pokedex.data.entity.pokemon.pokeathlonstats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NaturePokeathlonStatAffectSets {

	@SerializedName("increase")
	private List<NaturePokeathlonStatAffect> increaseStatList;      // A list of natures and how
																	// they change the referenced
																	// Pokéathlon stat.

	@SerializedName("decrease")
	private List<NaturePokeathlonStatAffect> decreaseStatList;      // A list of natures and how
																	// they change the referenced
																	// Pokéathlon stat.

}
