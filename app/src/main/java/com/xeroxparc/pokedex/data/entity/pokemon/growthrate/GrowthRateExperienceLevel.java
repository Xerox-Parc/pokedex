package com.xeroxparc.pokedex.data.entity.pokemon.growthrate;

import com.google.gson.annotations.SerializedName;

public class GrowthRateExperienceLevel {

	@SerializedName("level")
	private Integer level;                  //The level gained.

	@SerializedName("experience")
	private Integer experience;             //The amount of experience required to reach the
											// referenced level.
}
