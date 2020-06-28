package com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Pokeathlon Stats are different attributes of a Pokémon's performance in Pokéathlons.
 * In Pokéathlons, competitions happen on different courses; one for each of the different
 * Pokéathlon stats.
 * See Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
public class PokeathlonStat extends NamedAPIResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A detail of natures which affect this Pokéathlon stat positively or negatively.
	@SerializedName("affecting_natures")
	private NaturePokeathlonStatAffectSets affectingNatureSet;

}
