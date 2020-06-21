package com.xeroxparc.pokedex.data.entity.pokemon;

import com.xeroxparc.pokedex.data.entity.utility.NamedAPIResource;

public class PokemonAbility {

	private Boolean is_hidden;          //Whether or not this is a hidden ability.
	private Integer slot;               //The slot this ability occupies in this Pokémon species.
	private NamedAPIResource ability;   //The ability the Pokémon may have. (Ability)

}
