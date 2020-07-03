package com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Pokeathlon Stats are different attributes of a Pokémon's performance in Pokéathlons.
 * In Pokéathlons, competitions happen on different courses; one for each of the different
 * Pokéathlon stats.
 * See Bulbapedia for greater detail.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "pokeathlon_stat")
public class PokeathlonStat extends NamedApiResource {

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A detail of natures which affect this Pokéathlon stat positively or negatively.
	@ColumnInfo(name = "affecting_natures_data")
	@SerializedName("affecting_natures")
	private NaturePokeathlonStatAffectSets affectingNatureSet;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public NaturePokeathlonStatAffectSets getAffectingNatureSet() {
		return affectingNatureSet;
	}

	public void setAffectingNatureSet(NaturePokeathlonStatAffectSets affectingNatureSet) {
		this.affectingNatureSet = affectingNatureSet;
	}

}
