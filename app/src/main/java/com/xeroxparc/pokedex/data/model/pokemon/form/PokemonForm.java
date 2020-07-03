package com.xeroxparc.pokedex.data.model.pokemon.form;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

/**
 * Some Pokémon may appear in one of multiple, visually different forms. These differences are
 * purely cosmetic. For variations within a Pokémon species, which do differ in more than just
 * visuals, the 'Pokémon' entity is used to represent such a variety.
 *
 * @author Fabio Buracchi
 */
@Entity(tableName = "pokemon_form")
public class PokemonForm extends NamedApiResource {

	// The order in which forms should be sorted within all forms. Multiple forms may have equal order, in which case they should fall back on sorting by name.
	@ColumnInfo(name = "order")
	@SerializedName("order")
	private Integer order;

	// The order in which forms should be sorted within a species' forms.
	@ColumnInfo(name = "form_order")
	@SerializedName("form_order")
	private Integer formOrder;

	// Set for exactly one Pokémon used as the default for each species.
	@ColumnInfo(name = "is_default")
	@SerializedName("is_default")
	private Boolean isDefault;

	// Whether or not this form can only happen during battle.
	@ColumnInfo(name = "is_battle_only")
	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;

	// Whether or not this form requires mega evolution.
	@ColumnInfo(name = "is_mega")
	@SerializedName("is_mega")
	private Boolean isMega;

	// The name of this form.
	@ColumnInfo(name = "form_name")
	@SerializedName("form_name")
	private String formName;

	// The Pokémon that can take on this form.
	@ColumnInfo(name = "pokemon_data")
	@SerializedName("pokemon")
	private Pokemon pokemon;

	// A set of sprites used to depict this Pokémon form in the game.
	@ColumnInfo(name = "sprites_data")
	@SerializedName("sprites")
	private PokemonFormSprites sprites;

	// The version group this Pokémon form was introduced in.
	@ColumnInfo(name = "version_group_data")
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	// The form specific full name of this Pokémon form, or empty if the form does not have a specific name.
	@ColumnInfo(name = "names_data")
	@SerializedName("names")
	private List<Name> nameList;

	// The form specific form name of this Pokémon form, or empty if the form does not have a specific name.
	@ColumnInfo(name = "form_names_data")
	@SerializedName("form_names")
	private List<Name> formNameList;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getFormOrder() {
		return formOrder;
	}

	public void setFormOrder(Integer formOrder) {
		this.formOrder = formOrder;
	}

	public Boolean getDefault() {
		return isDefault;
	}

	public void setDefault(Boolean aDefault) {
		isDefault = aDefault;
	}

	public Boolean getBattleOnly() {
		return isBattleOnly;
	}

	public void setBattleOnly(Boolean battleOnly) {
		isBattleOnly = battleOnly;
	}

	public Boolean getMega() {
		return isMega;
	}

	public void setMega(Boolean mega) {
		isMega = mega;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public PokemonFormSprites getSprites() {
		return sprites;
	}

	public void setSprites(PokemonFormSprites sprites) {
		this.sprites = sprites;
	}

	public VersionGroup getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public List<Name> getNameList() {
		return nameList;
	}

	public void setNameList(List<Name> nameList) {
		this.nameList = nameList;
	}

	public List<Name> getFormNameList() {
		return formNameList;
	}

	public void setFormNameList(List<Name> formNameList) {
		this.formNameList = formNameList;
	}

}
