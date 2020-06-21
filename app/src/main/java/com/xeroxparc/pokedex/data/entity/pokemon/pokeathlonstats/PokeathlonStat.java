package com.xeroxparc.pokedex.data.entity.pokemon.pokeathlonstats;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;

import java.util.List;

public class PokeathlonStat {

	//Pokeathlon Stats are different attributes of a Pokémon's performance in Pokéathlons. In Pokéathlons, competitions happen on different courses; one for each of the different Pokéathlon stats. See Bulbapedia for greater detail.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private NaturePokeathlonStatAffectSets affecting_natures;   //A detail of natures which affect this Pokéathlon stat positively or negatively.

}
