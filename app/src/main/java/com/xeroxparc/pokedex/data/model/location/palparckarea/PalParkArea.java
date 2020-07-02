package com.xeroxparc.pokedex.data.model.location.palparckarea;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific to Pal Park.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "pal_park_area")
public class PalParkArea extends NamedApiResource {

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// A list of Pokémon encountered in the pal park area along with details.
	@SerializedName("pokemon_encounters")
	private List<PalParkEncounterSpecies> pokemonEncounterList;

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PalParkEncounterSpecies> getPokemonEncounterList() {
		return pokemonEncounterList;
	}

	public void setPokemonEncounterList(List<PalParkEncounterSpecies> pokemonEncounterList) {
		this.pokemonEncounterList = pokemonEncounterList;
	}

}
