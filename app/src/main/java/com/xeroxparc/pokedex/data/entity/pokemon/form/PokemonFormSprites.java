package com.xeroxparc.pokedex.data.entity.pokemon.form;

import com.google.gson.annotations.SerializedName;

public class PokemonFormSprites {

	@SerializedName("front_default")
	private String frontDefault;        // The default depiction of this Pokémon form from the front
										// in battle.

	@SerializedName("front_shiny")
	private String frontShiny;          // The shiny depiction of this Pokémon form from the front
										// in battle.

	@SerializedName("back_default")
	private String backDefault;         // The default depiction of this Pokémon form from the back
										// in battle.

	@SerializedName("back_shiny")
	private String backShiny;           // The shiny depiction of this Pokémon form from the back
										// in battle.

}
