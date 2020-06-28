package com.xeroxparc.pokedex.data.model.game.pokedex;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A Pokédex is a handheld electronic encyclopedia device; one which is capable of recording
 * and retaining information of the various Pokémon in a given region with the exception of the
 * national dex and some smaller dexes related to portions of a region.
 * See Bulbapedia for greater detail.
 * 	
 * @author Fabio Buracchi
 */
public class Pokedex extends NamedApiResource {

	// Whether or not this Pokédex originated in the main series of the video games.
	@SerializedName("is_main_series")
	private Boolean isMainSeries;

	// The description of this resource listed in different languages.
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of Pokémon catalogued in this Pokédex and their indexes.
	@SerializedName("pokemon_entries")
	private List<PokemonEntry> pokemonEntryList;

	// The region this Pokédex catalogues Pokémon for.
	@SerializedName("region")
	private Region region;

	// A list of version groups this Pokédex is relevant to.
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

}
