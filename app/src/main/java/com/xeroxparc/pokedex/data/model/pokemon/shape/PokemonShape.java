package com.xeroxparc.pokedex.data.model.pokemon.shape;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Shapes used for sorting Pokémon in a Pokédex.
 * 
 * @author Fabio Buracchi
 */
@Entity(tableName = "pokemon_shape")
public class PokemonShape extends NamedApiResource {

	// The "scientific" name of this Pokémon shape listed in different languages.
	@ColumnInfo(name = "awesome_names_data")
	@SerializedName("awesome_names")
	private List<AwesomeName> awesomeNameList;

	// The name of this resource listed in different languages.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// A list of the Pokémon species that have this shape.
	@ColumnInfo(name = "pokemon_species_data")
	@SerializedName("pokemon_species")
	private List<PokemonSpecies> pokemonSpeciesList;

	public List<AwesomeName> getAwesomeNameList() {
		return awesomeNameList;
	}

	public void setAwesomeNameList(List<AwesomeName> awesomeNameList) {
		this.awesomeNameList = awesomeNameList;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<PokemonSpecies> getPokemonSpeciesList() {
		return pokemonSpeciesList;
	}

	public void setPokemonSpeciesList(List<PokemonSpecies> pokemonSpeciesList) {
		this.pokemonSpeciesList = pokemonSpeciesList;
	}

}
