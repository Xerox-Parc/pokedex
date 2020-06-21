package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.xeroxparc.pokedex.data.entity.utility.common.Name;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;
import com.xeroxparc.pokedex.data.entity.utility.common.VerboseEffect;

import java.util.List;

public class Ability {

	//Abilities provide passive effects for Pokémon in battle or in the overworld. Pokémon have multiple possible abilities but can have only one ability at a time. Check out Bulbapedia for greater detail.

	private Integer id;                                         //The identifier for this resource.
	private String name;                                        //The name for this resource.
	private Boolean is_main_series;                             //Whether or not this ability originated in the main series of the video games.
	private NamedAPIResource generation;                        //The generation this ability originated in. (Generation)
	private List<Name> names;                                   //The name of this resource listed in different languages.
	private List<VerboseEffect> effect_entries;                 //The effect of this ability listed in different languages.
	private List<AbilityEffectChange> effect_changes;           //The list of previous effects this ability has had across version groups.
	private List<AbilityFlavorText> flavor_text_entries;        //The flavor text of this ability listed in different languages.
	private List<AbilityPokemon> pokemon;                       //A list of Pokémon that could potentially have this ability.

}
