package com.xeroxparc.pokedex.data.model.game.pokedex;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

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
@Entity(tableName = "pokedex")
public class Pokedex extends NamedApiResource {

	// Whether or not this Pokédex originated in the main series of the video games.
	@ColumnInfo(name = "is_main_series")
	@SerializedName("is_main_series")
	private Boolean isMainSeries;

	// The description of this resource listed in different languages.
	@ColumnInfo(name = "descriptions_data")
	@SerializedName("descriptions")
	private List<Description> descriptionList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of Pokémon catalogued in this Pokédex and their indexes.
	@ColumnInfo(name = "pokemon_entries_data")
	@SerializedName("pokemon_entries")
	private List<PokemonEntry> pokemonEntryList;

	// The region this Pokédex catalogues Pokémon for.
	@ColumnInfo(name = "region_data")
	@SerializedName("region")
	private Region region;

	// A list of version groups this Pokédex is relevant to.
	@ColumnInfo(name = "version_groups_data")
	@SerializedName("version_groups")
	private List<VersionGroup> versionGroupList;

	public Boolean getMainSeries() {
		return isMainSeries;
	}

	public void setMainSeries(Boolean mainSeries) {
		isMainSeries = mainSeries;
	}

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PokemonEntry> getPokemonEntryList() {
		return pokemonEntryList;
	}

	public void setPokemonEntryList(List<PokemonEntry> pokemonEntryList) {
		this.pokemonEntryList = pokemonEntryList;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<VersionGroup> getVersionGroupList() {
		return versionGroupList;
	}

	public void setVersionGroupList(List<VersionGroup> versionGroupList) {
		this.versionGroupList = versionGroupList;
	}

}
