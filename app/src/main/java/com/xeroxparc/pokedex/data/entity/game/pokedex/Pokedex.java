package com.xeroxparc.pokedex.data.entity.game.pokedex;

import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Pokedex {

	//A Pokédex is a handheld electronic encyclopedia device; one which is capable of recording and retaining information of the various Pokémon in a given region with the exception of the national dex and some smaller dexes related to portions of a region. See Bulbapedia for greater detail.

	private Integer id;                                 //The identifier for this resource.
	private String name;                                //The name for this resource.
	private Boolean is_main_series;                     //Whether or not this Pokédex originated in the main series of the video games.
	private List<Description> descriptions;             //The description of this resource listed in different languages.
	private List<Name> names;                           //The name of this resource listed in different languages.
	private List<PokemonEntry> pokemon_entries;         //A list of Pokémon catalogued in this Pokédex and their indexes.
	private NamedAPIResource region;                    //The region this Pokédex catalogues Pokémon for. (Region)
	private List<NamedAPIResource> version_groups;      //A list of version groups this Pokédex is relevant to. (VersionGroup)

}
