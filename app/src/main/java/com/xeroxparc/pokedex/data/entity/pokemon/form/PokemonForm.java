package com.xeroxparc.pokedex.data.entity.pokemon.form;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonForm {

	/*
		Some Pokémon may appear in one of multiple, visually different forms. These differences are
		purely cosmetic. For variations within a Pokémon species, which do differ in more than just
		visuals, the 'Pokémon' entity is used to represent such a variety.
	 */

	@SerializedName("id")
	private Integer id;                                 // The identifier for this resource.

	@SerializedName("name")
	private String name;                                // The name for this resource.

	@SerializedName("order")
	private Integer order;                              // The order in which forms should be sorted
														// within all forms. Multiple forms may have
														// equal order, in which case they should
														// fall back on sorting by name.

	@SerializedName("form_order")
	private Integer formOrder;                          // The order in which forms should be sorted
														// within a species' forms.

	@SerializedName("is_default")
	private Boolean isDefault;                          // Set for exactly one Pokémon used as the
														// default for each species.

	@SerializedName("is_battle_only")
	private Boolean isBattleOnly;                       // Whether or not this form can only happen
														// during battle.

	@SerializedName("is_mega")
	private Boolean isMega;                             // Whether or not this form requires mega
														// evolution.

	@SerializedName("form_name")
	private String formName;                            // The name of this form.

	@SerializedName("pokemon")
	private NamedAPIResource pokemonResource;           // The Pokémon that can take on this form.
														// (Pokemon)

	@SerializedName("sprites")
	private PokemonFormSprites sprites;                 // A set of sprites used to depict this
														// Pokémon form in the game.

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group this Pokémon form was
														// introduced in.
														// (VersionGroup)

	@SerializedName("names")
	private List<Name> nameList;                        // The form specific full name of this
														// Pokémon form, or empty if the form does
														// not have a specific name.

	@SerializedName("form_names")
	private List<Name> formNameList;                    // The form specific form name of this
														// Pokémon form, or empty if the form does
														// not have a specific name.

}
