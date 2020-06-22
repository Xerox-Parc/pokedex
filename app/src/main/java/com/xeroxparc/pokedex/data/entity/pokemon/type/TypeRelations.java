package com.xeroxparc.pokedex.data.entity.pokemon.type;

import com.google.gson.annotations.SerializedName;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResource;

import java.util.List;

public class TypeRelations {

	@SerializedName("no_damage_to")
	private List<NamedAPIResource> noDamageToListResource;          // A list of types this type has
																	// no effect on.
																	// (Type)

	@SerializedName("half_damage_to")
	private List<NamedAPIResource> halfDamageToListResource;        // A list of types this type is
																	// not very effect against.
																	// (Type)

	@SerializedName("double_damage_to")
	private List<NamedAPIResource> doubleDamageToListResource;      // A list of types this type is
																	// very effect against.
																	// (Type)

	@SerializedName("no_damage_from")
	private List<NamedAPIResource> noDamageFromListResource;        // A list of types that have no
																	// effect on this type.
																	// (Type)

	@SerializedName("half_damage_from")
	private List<NamedAPIResource> halfDamageFromListResource;      // A list of types that are not
																	// very effective against this
																	// type.
																	// (Type)

	@SerializedName("double_damage_from")
	private List<NamedAPIResource> doubleDamageFromListResource;    // A list of types that are
																	// very effective against this
																	// type.
																	// (Type)

}
