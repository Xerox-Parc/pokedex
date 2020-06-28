package com.xeroxparc.pokedex.data.model.location;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Locations that can be visited within the games. Locations make up sizable portions of
 * regions, like cities or routes.
 *
 * @author Fabio Buracchi
 */
public class Location extends NamedAPIResource {

	// The region this location can be found in.
	@SerializedName("region")
	private Region region;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of game indices relevent to this location by generation.
	@SerializedName("game_indices")
	private List<GenerationGameIndex> gameIndexList;

	// Areas that can be found within this location.
	@SerializedName("areas")
	private List<LocationArea> areaList;

}
