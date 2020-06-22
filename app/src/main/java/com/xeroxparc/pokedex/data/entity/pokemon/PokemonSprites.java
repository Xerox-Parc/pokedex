package com.xeroxparc.pokedex.data.entity.pokemon;

import com.google.gson.annotations.SerializedName;

public class PokemonSprites {

	@SerializedName("front_default")
	private String frontDefault;                // The default depiction of this Pokémon from the
												// front in battle.

	@SerializedName("front_shiny")
	private String frontShiny;                  // The shiny depiction of this Pokémon from the
												// front in battle.

	@SerializedName("front_female")
	private String frontFemale;                 // The female depiction of this Pokémon from the
												// front in battle.

	@SerializedName("front_shiny_female")
	private String frontShinyFemale;            // The shiny female depiction of this Pokémon from
												// the front in battle.

	@SerializedName("back_default")
	private String backDefault;                 // The default depiction of this Pokémon from the
												// back in battle.

	@SerializedName("back_shiny")
	private String backShiny;                   // The shiny depiction of this Pokémon from the
												// back in battle.

	@SerializedName("back_female")
	private String backFemale;                  // The female depiction of this Pokémon from the
												// back in battle.

	@SerializedName("back_shiny_female")
	private String backShinyFemale;             // The shiny female depiction of this Pokémon from
												// the back in battle.


}
