package com.xeroxparc.pokedex.data.entity.game.versiongroup;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class VersionGroup {

	/*
		Version groups categorize highly similar versions of the games.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("order")
	private Integer order;                                      // Order for sorting. Almost by date
																// of release, except similar
																// versions are grouped together.

	@SerializedName("generation")
	private NamedAPIResource generationResource;                // The generation this version was
																// introduced in.
																// (Generation)

	@SerializedName("move_learn_methods")
	private List<NamedAPIResource> moveLearnMethodListResource; // A list of methods in which
																// Pokémon can learn moves in this
																// version group.
																// (MoveLearnMethod)

	@SerializedName("pokedexes")
	private List<NamedAPIResource> pokedexListResource;         // A list of Pokédexes introduces in
																// this version group.
																// (Pokedex)

	@SerializedName("regions")
	private List<NamedAPIResource> regionListResource;          // A list of regions that can be
																// visited in this version group.
																// (Region)

	@SerializedName("versions")
	private List<NamedAPIResource> versionListResource;         // The versions this version group
																// owns.
																// (Version)

}
