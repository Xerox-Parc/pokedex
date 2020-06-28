package com.xeroxparc.pokedex.data.model.pokemon.form;

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
public class PokemonForm extends NamedApiResource {

	// The order in which forms should be sorted within all forms. Multiple forms may have equal order, in which case they should fall back on sorting by name.
	@SerializedName("order")
	private Integer order;

	// The order in which forms should be sorted within a species' forms.
	@SerializedName("form_order")
	private Integer formOrder;

	// Set for exactly one Pokémon used as the default for each species.
	@SerializedName("is_default")
	private Boolean isDefault;

	// Whether or not this form can only happen during battle.
	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;

	// Whether or not this form requires mega evolution.
	@SerializedName("is_mega")
	private Boolean isMega;

	// The name of this form.
	@SerializedName("form_name")
	private String formName;

	// The Pokémon that can take on this form.
	@SerializedName("pokemon")
	private Pokemon pokemon;

	// A set of sprites used to depict this Pokémon form in the game.
	@SerializedName("sprites")
	private PokemonFormSprites sprites;

	// The version group this Pokémon form was introduced in.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

	// The form specific full name of this Pokémon form, or empty if the form does not have a specific name.
	@SerializedName("names")
	private List<Name> nameList;

	// The form specific form name of this Pokémon form, or empty if the form does not have a specific name.
	@SerializedName("form_names")
	private List<Name> formNameList;

}
