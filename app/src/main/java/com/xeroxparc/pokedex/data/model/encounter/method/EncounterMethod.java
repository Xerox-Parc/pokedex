package com.xeroxparc.pokedex.data.model.encounter.method;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall
 * grass. Check out Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class EncounterMethod extends NamedAPIResource {

	// A good value for sorting.
	@SerializedName("order")
	private Integer order;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

}