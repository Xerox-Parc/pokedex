package com.xeroxparc.pokedex.data.model.location.region;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A region is an organized area of the Pokémon world. Most often, the main difference between
 * regions is the species of Pokémon that can be encountered within them.
 * 
 * @author Fabio Buracchi
 */
public class Region extends NamedApiResource {
	
	// A list of locations that can be found in this region.
	@SerializedName("locations")
	private List<Location> locationList;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The generation this region was introduced in.
	@SerializedName("main_generation")
	private Generation mainGeneration;

	// A list of pokédexes that catalogue Pokémon in this region.
	@SerializedName("pokedexes")
	private List<Pokedex> pokedexList;

	// A list of version groups where this region can be visited.
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

}
