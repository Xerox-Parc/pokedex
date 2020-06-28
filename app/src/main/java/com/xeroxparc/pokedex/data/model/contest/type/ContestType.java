package com.xeroxparc.pokedex.data.model.contest.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests.
 * Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class ContestType extends NamedApiResource {

	// The berry flavor that correlates with this contest type.
	@SerializedName("berry_flavor")
	private BerryFlavor berryFlavor;

	// The name of this contest type listed in different languages.
	@SerializedName("names")
	private List<ContestName> contestNameList;

}
