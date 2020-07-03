package com.xeroxparc.pokedex.data.model.pokemon.form;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class PokemonFormSprites {

	// The default depiction of this Pokémon form from the front in battle.
	@SerializedName("front_default")
	private String frontDefault;

	// The shiny depiction of this Pokémon form from the front in battle.
	@SerializedName("front_shiny")
	private String frontShiny;

	// The default depiction of this Pokémon form from the back in battle.
	@SerializedName("back_default")
	private String backDefault;

	// The shiny depiction of this Pokémon form from the back in battle.
	@SerializedName("back_shiny")
	private String backShiny;

	public String getFrontDefault() {
		return frontDefault;
	}

	public String getFrontShiny() {
		return frontShiny;
	}

	public String getBackDefault() {
		return backDefault;
	}

	public String getBackShiny() {
		return backShiny;
	}

}
