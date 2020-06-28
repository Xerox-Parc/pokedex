package com.xeroxparc.pokedex.data.model.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;

import java.util.List;

/**
 * Abilities provide passive effects for Pokémon in battle or in the overworld.
 * Pokémon have multiple possible abilities but can have only one ability at a time.
 * Check out Bulbapedia for greater detail.
 * 	
 * @author Fabio Buracchi
 */
public class Ability extends NamedAPIResource {

	// Whether or not this ability originated in the main series of the video games.
	@SerializedName("is_main_series")
	private Boolean isMainSeries;

	// The generation this ability originated in.
	@SerializedName("generation")
	private Generation generation;

	// The name of this resource listed in different languages.
	@SerializedName("names")
	private List<Name> nameList;

	// The effect of this ability listed in different languages.
	@SerializedName("effect_entries")
	private List<VerboseEffect> effectEntryList;

	// The list of previous effects this ability has had across version groups.
	@SerializedName("effect_changes")
	private List<AbilityEffectChange> effectChangeList;

	// The flavor text of this ability listed in different languages.
	@SerializedName("flavor_text_entries")
	private List<AbilityFlavorText> flavorTextEntryList;

	// A list of Pokémon that could potentially have this ability.
	@SerializedName("pokemon")
	private List<AbilityPokemon> pokemonList;

}
