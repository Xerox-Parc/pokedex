package com.xeroxparc.pokedex.data.entity.pokemon.form;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class PokemonForm {

	//Some Pokémon may appear in one of multiple, visually different forms. These differences are purely cosmetic. For variations within a Pokémon species, which do differ in more than just visuals, the 'Pokémon' entity is used to represent such a variety.

	private Integer id;                             //The identifier for this resource.
	private String name;                            //The name for this resource.
	private Integer order;                          //The order in which forms should be sorted within all forms. Multiple forms may have equal order, in which case they should fall back on sorting by name.
	private Integer form_order;                     //The order in which forms should be sorted within a species' forms.
	private Boolean is_default;                     //Set for exactly one Pokémon used as the default for each species.
	private Boolean is_battle_only;                 //Whether or not this form can only happen during battle.
	private Boolean is_mega;                        //Whether or not this form requires mega evolution.
	private String form_name;                       //The name of this form.
	private NamedAPIResource pokemon;               //The Pokémon that can take on this form. (Pokemon)
	private PokemonFormSprites sprites;             //A set of sprites used to depict this Pokémon form in the game.
	private NamedAPIResource version_group;         //The version group this Pokémon form was introduced in. (VersionGroup)
	private List<Name> names;                       //The form specific full name of this Pokémon form, or empty if the form does not have a specific name.
	private List<Name> form_names;                  //The form specific form name of this Pokémon form, or empty if the form does not have a specific name.

}
