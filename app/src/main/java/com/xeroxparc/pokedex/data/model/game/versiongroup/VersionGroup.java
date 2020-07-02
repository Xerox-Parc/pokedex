package com.xeroxparc.pokedex.data.model.game.versiongroup;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.version.Version;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Version groups categorize highly similar versions of the games.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "version_group")
public class VersionGroup extends NamedApiResource {

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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public List<MoveLearnMethod> getMoveLearnMethodList() {
		return moveLearnMethodList;
	}

	public void setMoveLearnMethodList(List<MoveLearnMethod> moveLearnMethodList) {
		this.moveLearnMethodList = moveLearnMethodList;
	}

	public List<Pokedex> getPokedexList() {
		return pokedexList;
	}

	public void setPokedexList(List<Pokedex> pokedexList) {
		this.pokedexList = pokedexList;
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	public List<Version> getVersionList() {
		return versionList;
	}

	public void setVersionList(List<Version> versionList) {
		this.versionList = versionList;
	}

}
