package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;

/**
 * @author Fabio Buracchi
 */
public class PokemonAbility {

	// Whether or not this is a hidden ability.
	@SerializedName("is_hidden")
	private Boolean isHidden;

	// The slot this ability occupies in this Pokémon species.
	@SerializedName("slot")
	private Integer slot;

	// The ability the Pokémon may have.
	@SerializedName("ability")
	private Ability ability;

	public Boolean getHidden() {
		return isHidden;
	}

	public Integer getSlot() {
		return slot;
	}

	public Ability getAbility() {
		return ability;
	}

}
