package com.xeroxparc.pokedex.data.model.pokemon.growthrate;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class GrowthRateExperienceLevel {

	// The level gained.
	@SerializedName("level")
	private Integer level;

	// The amount of experience required to reach the referenced level.
	@SerializedName("experience")
	private Integer experience;

	public Integer getLevel() {
		return level;
	}

	public Integer getExperience() {
		return experience;
	}

}
