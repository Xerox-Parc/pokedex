package com.xeroxparc.pokedex.data.model.berry.flavor;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on
 * their nature. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class BerryFlavor extends NamedAPIResource {

	// A list of the berries with this flavor.
	@SerializedName("berries")
	private List<FlavorBerryMap> flavorBerryMapList;

	// The contest type that correlates with this berry flavor.
	@SerializedName("contest_type")
	private ContestType contestType;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}
