package com.xeroxparc.pokedex.data.model.game.versiongroup;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.version.Version;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;

import java.util.List;

/**
 * Version groups categorize highly similar versions of the games.
 * 
 * @author Fabio Buracchi
 */
public class VersionGroup extends NamedAPIResource {

	// Order for sorting. Almost by date of release, except similar versions are grouped together.
	@SerializedName("order")
	private Integer order;

	// The generation this version was introduced in.
	@SerializedName("generation")
	private Generation generation;

	// A list of methods in which Pokémon can learn moves in this version group.
	@SerializedName("move_learn_methods")
	private List<MoveLearnMethod> moveLearnMethodList;

	// A list of Pokédexes introduces in this version group.
	@SerializedName("pokedexes")
	private List<Pokedex> pokedexList;

	// A list of regions that can be visited in this version group.
	@SerializedName("regions")
	private List<Region> regionList;

	// The versions this version group owns.
	@SerializedName("versions")
	private List<Version> versionList;

}
