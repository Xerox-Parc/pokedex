package com.xeroxparc.pokedex.data.model.game.generation;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * A generation is a grouping of the Pokémon games that separates them based on the Pokémon
 * they include. In each generation, a new set of Pokémon, Moves, Abilities and Types that did
 * not exist in the previous generation are released.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "generation")
public class Generation extends NamedApiResource {

	// A list of abilities that were introduced in this generation.
	@ColumnInfo(name = "abilities_data")
	@SerializedName("abilities")
	private List<Ability> abilityList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// The main region travelled in this generation.
	@ColumnInfo(name = "main_region_data")
	@SerializedName("main_region")
	private Region mainRegion;

	// A list of moves that were introduced in this generation.
	@ColumnInfo(name = "moves_data")
	@SerializedName("moves")
	private List<Move> moveList;

	// A list of Pokémon species that were introduced in this generation.
	@ColumnInfo(name = "pokemon_species_data")
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

	// A list of types that were introduced in this generation.
	@ColumnInfo(name = "types_data")
	@SerializedName("types")
	private List<Type> typeList;

	// A list of version groups that were introduced in this generation.
	@ColumnInfo(name = "version_groups_data")
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

	public List<Ability> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(List<Ability> abilityList) {
		this.abilityList = abilityList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public Region getMainRegion() {
		return mainRegion;
	}

	public void setMainRegion(Region mainRegion) {
		this.mainRegion = mainRegion;
	}

	public List<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(List<Move> moveList) {
		this.moveList = moveList;
	}

	public List<PokemonSpecies> getPokemonSpeciesList() {
		return pokemonSpeciesList;
	}

	public void setPokemonSpeciesList(List<PokemonSpecies> pokemonSpeciesList) {
		this.pokemonSpeciesList = pokemonSpeciesList;
	}

	public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public List<VersionGroup> getVersionGroupList() {
		return versionGroupList;
	}

	public void setVersionGroupList(List<VersionGroup> versionGroupList) {
		this.versionGroupList = versionGroupList;
	}

}
