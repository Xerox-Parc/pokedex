package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

public class AbilityPokemon {

	private Boolean is_hidden;          //Whether or not this a hidden ability for the referenced Pokémon.
	private Integer slot;               //Pokémon have 3 ability 'slots' which hold references to possible abilities they could have. This is the slot of this ability for the referenced pokemon.
	private NamedAPIResource pokemon;   //The Pokémon this ability could belong to. (Pokemon)

}
