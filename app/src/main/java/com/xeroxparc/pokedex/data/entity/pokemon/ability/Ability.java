package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;

import java.util.List;

public class Ability {

	/*
		Abilities provide passive effects for Pokémon in battle or in the overworld.
		Pokémon have multiple possible abilities but can have only one ability at a time.
		Check out Bulbapedia for greater detail.
	 */

	@SerializedName("id")
	private Integer id;                                         // The identifier for this resource.

	@SerializedName("name")
	private String name;                                        // The name for this resource.

	@SerializedName("is_main_series")
	private Boolean isMainSeries;                               // Whether or not this ability
																// originated in the main series
																// of the video games.

	@SerializedName("generation")
	private NamedAPIResource generationResource;                // The generation this ability
																// originated in.
																// (Generation)

	@SerializedName("names")
	private List<Name> nameList;                                // The name of this resource listed
																// in different languages.

	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;                // The effect of this ability listed
																// in different languages.

	@SerializedName("effect_changes")
	private List<AbilityEffectChange> effectChangeList;         // The list of previous effects this
																// ability has had across version
																// groups.

	@SerializedName("flavor_text_entries")
	private List<AbilityFlavorText> flavorTextEntryList;        // The flavor text of this ability
																// listed in different languages.

	@SerializedName("pokemon")
	private List<AbilityPokemon> pokemonList;                   // A list of Pokémon that could
																// potentially have this ability.

}
