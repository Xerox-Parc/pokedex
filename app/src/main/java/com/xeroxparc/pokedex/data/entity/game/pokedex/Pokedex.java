package com.xeroxparc.pokedex.data.entity.game.pokedex;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Description;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class Pokedex {

	/*
		A Pokédex is a handheld electronic encyclopedia device; one which is capable of recording
		and retaining information of the various Pokémon in a given region with the exception of the
		national dex and some smaller dexes related to portions of a region.
		See Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("is_main_series")
	private Boolean isMainSeries;                               // Whether or not this Pokédex
																// originated in the main series of
																// the video games.

	@SerializedName("descriptions")
	private List<Description> descriptionList;                  // The description of this resource
																// listed in different languages.

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("pokemon_entries")
	private List<PokemonEntry> pokemonEntryList;                // A list of Pokémon catalogued in
																// this Pokédex and their indexes.

	@SerializedName("region")
	private NamedAPIResource regionResource;                    // The region this Pokédex
																// catalogues Pokémon for.
																// (Region)

	@SerializedName("version_groups")
	private List<NamedAPIResource> versionGroupListResource;    // A list of version groups this
																// Pokédex is relevant to.
																// (VersionGroup)

}
