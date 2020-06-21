package com.xeroxparc.pokedex.data.remote;

import com.xeroxparc.pokedex.data.entity.berry.Berry;
import com.xeroxparc.pokedex.data.entity.berry.firmness.BerryFirmness;
import com.xeroxparc.pokedex.data.entity.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.entity.contest.effect.ContestEffect;
import com.xeroxparc.pokedex.data.entity.contest.effectsuper.SuperContestEffect;
import com.xeroxparc.pokedex.data.entity.contest.type.ContestType;
import com.xeroxparc.pokedex.data.entity.encounter.condition.EncounterCondition;
import com.xeroxparc.pokedex.data.entity.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.entity.encounter.method.EncounterMethod;
import com.xeroxparc.pokedex.data.entity.evolutions.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.entity.evolutions.trigger.EvolutionTrigger;
import com.xeroxparc.pokedex.data.entity.game.generation.Generation;
import com.xeroxparc.pokedex.data.entity.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.entity.game.version.Version;
import com.xeroxparc.pokedex.data.entity.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.entity.item.Item;
import com.xeroxparc.pokedex.data.entity.item.attribute.ItemAttribute;
import com.xeroxparc.pokedex.data.entity.item.category.ItemCategory;
import com.xeroxparc.pokedex.data.entity.item.effect.ItemFlingEffect;
import com.xeroxparc.pokedex.data.entity.item.pocket.ItemPocket;
import com.xeroxparc.pokedex.data.entity.location.Location;
import com.xeroxparc.pokedex.data.entity.location.area.LocationArea;
import com.xeroxparc.pokedex.data.entity.location.palparckarea.PalParkArea;
import com.xeroxparc.pokedex.data.entity.location.region.Region;
import com.xeroxparc.pokedex.data.entity.machine.Machine;
import com.xeroxparc.pokedex.data.entity.move.Move;
import com.xeroxparc.pokedex.data.entity.move.ailment.MoveAilment;
import com.xeroxparc.pokedex.data.entity.move.battlestyle.MoveBattleStyle;
import com.xeroxparc.pokedex.data.entity.move.categoty.ModelName;
import com.xeroxparc.pokedex.data.entity.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.entity.move.learnmethod.MoveLearnMethod;
import com.xeroxparc.pokedex.data.entity.move.target.MoveTarget;
import com.xeroxparc.pokedex.data.entity.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.entity.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.entity.pokemon.characteristic.Characteristic;
import com.xeroxparc.pokedex.data.entity.pokemon.color.PokemonColor;
import com.xeroxparc.pokedex.data.entity.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.entity.pokemon.form.PokemonForm;
import com.xeroxparc.pokedex.data.entity.pokemon.gender.Gender;
import com.xeroxparc.pokedex.data.entity.pokemon.growthrate.GrowthRate;
import com.xeroxparc.pokedex.data.entity.pokemon.habitat.PokemonHabitat;
import com.xeroxparc.pokedex.data.entity.pokemon.nature.Nature;
import com.xeroxparc.pokedex.data.entity.pokemon.pokeathlonstats.PokeathlonStat;
import com.xeroxparc.pokedex.data.entity.pokemon.shape.PokemonShape;
import com.xeroxparc.pokedex.data.entity.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.entity.pokemon.stats.Stat;
import com.xeroxparc.pokedex.data.entity.pokemon.type.Type;
import com.xeroxparc.pokedex.data.entity.utility.language.Language;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeAPIService {

	@GET("berry/{id}")
	Call<Berry> getBerry(@Path("id") Integer id);

	@GET("berry/{name}")
	Call<Berry> getBerry(@Path("name") String name);

	@GET("berry-firmness/{id}")
	Call<BerryFirmness> getBerryFirmness(@Path("id") Integer id);

	@GET("berry-firmness/{name}")
	Call<BerryFirmness> getBerryFirmness(@Path("name") String name);

	@GET("berry-flavor/{id}")
	Call<BerryFlavor> getBerryFlavor(@Path("id") Integer id);

	@GET("berry-flavor/{name}")
	Call<BerryFlavor> getBerryFlavor(@Path("name") String name);

	@GET("contest-type/{id}")
	Call<ContestType> getContestType(@Path("id") Integer id);

	@GET("contest-type/{name}")
	Call<ContestType> getContestType(@Path("name") String name);

	@GET("contest-effect/{id}")
	Call<ContestEffect> getContestEffect(@Path("id") Integer id);

	@GET("super-contest-effect/{id}")
	Call<SuperContestEffect> getSuperContestEffect(@Path("id") Integer id);

	@GET("encounter-method/{id}")
	Call<EncounterMethod> getEncounterMethod(@Path("id") Integer id);

	@GET("encounter-method/{name}")
	Call<EncounterMethod> getEncounterMethod(@Path("name") String name);

	@GET("encounter-condition/{id}")
	Call<EncounterCondition> getEncounterCondition(@Path("id") Integer id);

	@GET("encounter-condition/{name}")
	Call<EncounterCondition> getEncounterCondition(@Path("name") String name);

	@GET("encounter-condition-value/{id}")
	Call<EncounterConditionValue> getEncounterConditionValue(@Path("id") Integer id);

	@GET("encounter-condition-value/{name}")
	Call<EncounterConditionValue> getEncounterConditionValue(@Path("name") String name);

	@GET("evolution-chain/{id}")
	Call<EvolutionChain> getEvolutionChain(@Path("id") Integer id);

	@GET("evolution-trigger/{id}")
	Call<EvolutionTrigger> getEvolutionTrigger(@Path("id") Integer id);

	@GET("evolution-trigger/{name}")
	Call<EvolutionTrigger> getEvolutionTrigger(@Path("name") String name);

	@GET("generation/{id}")
	Call<Generation> getGeneration(@Path("id") Integer id);

	@GET("generation/{name}")
	Call<Generation> getGeneration(@Path("name") String name);

	@GET("pokedex/{id}")
	Call<Pokedex> getPokedex(@Path("id") Integer id);

	@GET("pokedex/{name}")
	Call<Pokedex> getPokedex(@Path("name") String name);

	@GET("version/{id}")
	Call<Version> getVersion(@Path("id") Integer id);

	@GET("version/{name}")
	Call<Version> getVersion(@Path("name") String name);

	@GET("version-group/{id}")
	Call<VersionGroup> getVersionGroup(@Path("id") Integer id);

	@GET("version-group/{name}")
	Call<VersionGroup> getVersionGroup(@Path("name") String name);

	@GET("item/{id}")
	Call<Item> getItem(@Path("id") Integer id);

	@GET("item/{name}")
	Call<Item> getItem(@Path("name") String name);

	@GET("item-attribute/{id}")
	Call<ItemAttribute> getItemAttribute(@Path("id") Integer id);

	@GET("item-attribute/{name}")
	Call<ItemAttribute> getItemAttribute(@Path("name") String name);

	@GET("item-category/{id}")
	Call<ItemCategory> getItemCategory(@Path("id") Integer id);

	@GET("item-category/{name}")
	Call<ItemCategory> getItemCategory(@Path("name") String name);

	@GET("item-fling-effect/{id}")
	Call<ItemFlingEffect> getItemFlingEffect(@Path("id") Integer id);

	@GET("item-fling-effect/{name}")
	Call<ItemFlingEffect> getItemFlingEffect(@Path("name") String name);

	@GET("item-pocket/{id}")
	Call<ItemPocket> getItemPocket(@Path("id") Integer id);

	@GET("item-pocket/{name}")
	Call<ItemPocket> getItemPocket(@Path("name") String name);

	@GET("location/{id}")
	Call<Location> getLocation(@Path("id") Integer id);

	@GET("location/{name}")
	Call<Location> getLocation(@Path("name") String name);

	@GET("location-area/{id}")
	Call<LocationArea> getLocationArea(@Path("id") Integer id);

	@GET("location-area/{name}")
	Call<LocationArea> getLocationArea(@Path("name") String name);

	@GET("pal-park-area/{id}")
	Call<PalParkArea> getPalParkArea(@Path("id") Integer id);

	@GET("pal-park-area/{name}")
	Call<PalParkArea> getPalParkArea(@Path("name") String name);

	@GET("region/{id}")
	Call<Region> getRegion(@Path("id") Integer id);

	@GET("region/{name}")
	Call<Region> getRegion(@Path("name") String name);

	@GET("machine/{id}")
	Call<Machine> getMachine(@Path("id") Integer id);

	@GET("move/{id}")
	Call<Move> getMove(@Path("id") Integer id);

	@GET("move/{name}")
	Call<Move> getMove(@Path("name") String name);

	@GET("move-ailment/{id}")
	Call<MoveAilment> getMoveAilment(@Path("id") Integer id);

	@GET("move-ailment/{name}")
	Call<MoveAilment> getMoveAilment(@Path("name") String name);

	@GET("move-battle-style/{id}")
	Call<MoveBattleStyle> getMoveBattleStyle(@Path("id") Integer id);

	@GET("move-battle-style/{name}")
	Call<MoveBattleStyle> getMoveBattleStyle(@Path("name") String name);

	@GET("move-category/{id}")
	Call<ModelName> getModelName(@Path("id") Integer id);

	@GET("move-category/{name}")
	Call<ModelName> getModelName(@Path("name") String name);

	@GET("move-damage-class/{id}")
	Call<MoveDamageClass> getMoveDamageClass(@Path("id") Integer id);

	@GET("move-damage-class/{name}")
	Call<MoveDamageClass> getMoveDamageClass(@Path("name") String name);

	@GET("move-learn-method/{id}")
	Call<MoveLearnMethod> getMoveLearnMethod(@Path("id") Integer id);

	@GET("move-learn-method/{name}")
	Call<MoveLearnMethod> getMoveLearnMethod(@Path("name") String name);

	@GET("move-target/{id}")
	Call<MoveTarget> getMoveTarget(@Path("id") Integer id);

	@GET("move-target/{name}")
	Call<MoveTarget> getMoveTarget(@Path("name") String name);

	@GET("ability/{id}")
	Call<Ability> getAbility(@Path("id") Integer id);

	@GET("ability/{name}")
	Call<Ability> getAbility(@Path("name") String name);

	@GET("characteristic/{id}")
	Call<Characteristic> getCharacteristic(@Path("id") Integer id);

	@GET("egg-group/{id}")
	Call<EggGroup> getEggGroup(@Path("id") Integer id);

	@GET("egg-group/{name}")
	Call<EggGroup> getEggGroup(@Path("name") String name);

	@GET("gender/{id}")
	Call<Gender> getGender(@Path("id") Integer id);

	@GET("gender/{name}")
	Call<Gender> getGender(@Path("name") String name);

	@GET("growth-rate/{id}")
	Call<GrowthRate> getGrowthRate(@Path("id") Integer id);

	@GET("growth-rate/{name}")
	Call<GrowthRate> getGrowthRate(@Path("name") String name);

	@GET("nature/{id}")
	Call<Nature> getNature(@Path("id") Integer id);

	@GET("nature/{name}")
	Call<Nature> getNature(@Path("name") String name);

	@GET("pokeathlon-stat/{id}")
	Call<PokeathlonStat> getPokeathlonStat(@Path("id") Integer id);

	@GET("pokeathlon-stat/{name}")
	Call<PokeathlonStat> getPokeathlonStat(@Path("name") String name);

	@GET("pokemon/{id}")
	Call<Pokemon> getPokemon(@Path("id") Integer id);

	@GET("pokemon/{name}")
	Call<Pokemon> getPokemon(@Path("name") String name);

	@GET("pokemon-color/{id}")
	Call<PokemonColor> getPokemonColor(@Path("id") Integer id);

	@GET("pokemon-color/{name}")
	Call<PokemonColor> getPokemonColor(@Path("name") String name);

	@GET("pokemon-form/{id}")
	Call<PokemonForm> getPokemonForm(@Path("id") Integer id);

	@GET("pokemon-form/{name}")
	Call<PokemonForm> getPokemonForm(@Path("name") String name);

	@GET("pokemon-habitat/{id}")
	Call<PokemonHabitat> getPokemonHabitat(@Path("id") Integer id);

	@GET("pokemon-habitat/{name}")
	Call<PokemonHabitat> getPokemonHabitat(@Path("name") String name);

	@GET("pokemon-shape/{id}")
	Call<PokemonShape> getPokemonShape(@Path("id") Integer id);

	@GET("pokemon-shape/{name}")
	Call<PokemonShape> getPokemonShape(@Path("name") String name);

	@GET("pokemon-species/{id}")
	Call<PokemonSpecies> getPokemonSpecies(@Path("id") Integer id);

	@GET("pokemon-species/{name}")
	Call<PokemonSpecies> getPokemonSpecies(@Path("name") String name);

	@GET("stat/{id}")
	Call<Stat> getStat(@Path("id") Integer id);

	@GET("stat/{name}")
	Call<Stat> getStat(@Path("name") String name);

	@GET("type/{id}")
	Call<Type> getType(@Path("id") Integer id);

	@GET("type/{name}")
	Call<Type> getType(@Path("name") String name);

	@GET("language/{id}")
	Call<Language> getLanguage(@Path("id") Integer id);

	@GET("language/{name}")
	Call<Language> getLanguage(@Path("name") String name);

}
