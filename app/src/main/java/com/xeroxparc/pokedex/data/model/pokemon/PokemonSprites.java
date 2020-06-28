package com.xeroxparc.pokedex.data.model.pokemon;

import com.google.gson.annotations.SerializedName;

/**
 * @author Fabio Buracchi
 */
public class PokemonSprites {

	// The default depiction of this Pokémon from the front in battle.
	@SerializedName("front_default")
	private String frontDefault;

	// The shiny depiction of this Pokémon from the front in battle.
	@SerializedName("front_shiny")
	private String frontShiny;

	// The female depiction of this Pokémon from the front in battle.
	@SerializedName("front_female")
	private String frontFemale;

	// The shiny female depiction of this Pokémon from the front in battle.
	@SerializedName("front_shiny_female")
	private String frontShinyFemale;

	// The default depiction of this Pokémon from the back in battle.
	@SerializedName("back_default")
	private String backDefault;

	// The shiny depiction of this Pokémon from the back in battle.
	@SerializedName("back_shiny")
	private String backShiny;

	// The female depiction of this Pokémon from the back in battle.
	@SerializedName("back_female")
	private String backFemale;

	// The shiny female depiction of this Pokémon from the back in battle.
	@SerializedName("back_shiny_female")
	private String backShinyFemale;


}
