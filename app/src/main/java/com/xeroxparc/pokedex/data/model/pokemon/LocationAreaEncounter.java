package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.model.utility.common.VersionEncounterDetail;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class LocationAreaEncounter {

	// The location area the referenced Pokémon can be encountered in.
	@SerializedName("location_area")
	private LocationArea locationArea;

	// A list of versions and encounters with the referenced Pokémon that might happen.
	@SerializedName("version_details")
	private List<VersionEncounterDetail> versionEncounterDetailList;

}
