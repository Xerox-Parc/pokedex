package com.xeroxparc.pokedex.data.model.pokemon.ability;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;

import java.util.List;

/**
 * @author Fabio Buracchi
 */
public class AbilityEffectChange {

	// The previous effect of this ability listed in different languages.
	@SerializedName("effect_entries")
	private List<Effect> effectEntryList;

	// The version group in which the previous effect of this ability originated.
	@SerializedName("version_group")
	private VersionGroup versionGroup;

}
