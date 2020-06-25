package com.xeroxparc.pokedex.data.entity.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.Effect;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class AbilityEffectChange {

	@SerializedName("effect_entries")
	private List<Effect> effectEntryList;               // The previous effect of this ability listed
														// in different languages.

	@SerializedName("version_group")
	private NamedAPIResource versionGroupResource;      // The version group in which the previous
														// effect of this ability originated.
														// (VersionGroup)

}
