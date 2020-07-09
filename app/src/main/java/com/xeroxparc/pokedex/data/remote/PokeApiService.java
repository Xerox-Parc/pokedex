package com.xeroxparc.pokedex.data.remote;

import androidx.annotation.NonNull;

import com.xeroxparc.pokedex.data.model.berry.Berry;
import com.xeroxparc.pokedex.data.model.berry.firmness.BerryFirmness;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.contest.effect.ContestEffect;
import com.xeroxparc.pokedex.data.model.contest.supereffect.SuperContestEffect;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;
import com.xeroxparc.pokedex.data.model.encounter.condition.EncounterCondition;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.model.encounter.method.EncounterMethod;
import com.xeroxparc.pokedex.data.model.evolution.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.model.evolution.trigger.EvolutionTrigger;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.version.Version;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.item.attribute.ItemAttribute;
import com.xeroxparc.pokedex.data.model.item.category.ItemCategory;
import com.xeroxparc.pokedex.data.model.item.effect.ItemFlingEffect;
import com.xeroxparc.pokedex.data.model.item.pocket.ItemPocket;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.model.location.palparckarea.PalParkArea;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.machine.Machine;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.move.ailment.MoveAilment;
import com.xeroxparc.pokedex.data.model.move.battlestyle.MoveBattleStyle;
import com.xeroxparc.pokedex.data.model.move.categoty.MoveCategory;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;
import com.xeroxparc.pokedex.data.model.move.target.MoveTarget;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.model.pokemon.characteristic.Characteristic;
import com.xeroxparc.pokedex.data.model.pokemon.color.PokemonColor;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.form.PokemonForm;
import com.xeroxparc.pokedex.data.model.pokemon.gender.Gender;
import com.xeroxparc.pokedex.data.model.pokemon.growthrate.GrowthRate;
import com.xeroxparc.pokedex.data.model.pokemon.habitat.PokemonHabitat;
import com.xeroxparc.pokedex.data.model.pokemon.nature.Nature;
import com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats.PokeathlonStat;
import com.xeroxparc.pokedex.data.model.pokemon.shape.PokemonShape;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.utility.common.ResourceList;
import com.xeroxparc.pokedex.data.model.utility.language.Language;
import com.xeroxparc.pokedex.data.remote.call.PokeCall;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Fabio Buracchi
 */
public interface PokeApiService {


	@GET("berry/")
	PokeCall<ResourceList<Berry>> getBerryList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("berry/{id}")
	PokeCall<Berry> getBerry(
			@Path("id") @NonNull Integer id
	);

	@GET("berry/{name}")
	PokeCall<Berry> getBerry(
			@Path("name") @NonNull String name
	);

	@GET("berry-firmness/")
	PokeCall<ResourceList<BerryFirmness>> getBerryFirmnessList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("berry-firmness/{id}")
	PokeCall<BerryFirmness> getBerryFirmness(
			@Path("id") @NonNull Integer id
	);

	@GET("berry-firmness/{name}")
	PokeCall<BerryFirmness> getBerryFirmness(
			@Path("name") @NonNull String name
	);

	@GET("berry-flavor/")
	PokeCall<ResourceList<BerryFlavor>> getBerryFlavorList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("berry-flavor/{id}")
	PokeCall<BerryFlavor> getBerryFlavor(
			@Path("id") @NonNull Integer id
	);

	@GET("berry-flavor/{name}")
	PokeCall<BerryFlavor> getBerryFlavor(
			@Path("name") @NonNull String name
	);

	@GET("contest-type/")
	PokeCall<ResourceList<ContestType>> getContestTypeList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("contest-type/{id}")
	PokeCall<ContestType> getContestType(
			@Path("id") @NonNull Integer id
	);

	@GET("contest-type/{name}")
	PokeCall<ContestType> getContestType(
			@Path("name") @NonNull String name
	);

	@GET("contest-effect/")
	PokeCall<ResourceList<ContestEffect>> getContestEffectList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("contest-effect/{id}")
	PokeCall<ContestEffect> getContestEffect(
			@Path("id") @NonNull Integer id
	);

	@GET("super-contest-effect/")
	PokeCall<ResourceList<SuperContestEffect>> getSuperContestEffectList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("super-contest-effect/{id}")
	PokeCall<SuperContestEffect> getSuperContestEffect(
			@Path("id") @NonNull Integer id
	);

	@GET("encounter-method/")
	PokeCall<ResourceList<EncounterMethod>> getEncounterMethodList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("encounter-method/{id}")
	PokeCall<EncounterMethod> getEncounterMethod(
			@Path("id") @NonNull Integer id
	);

	@GET("encounter-method/{name}")
	PokeCall<EncounterMethod> getEncounterMethod(
			@Path("name") @NonNull String name
	);

	@GET("encounter-condition/")
	PokeCall<ResourceList<EncounterCondition>> getEncounterConditionList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("encounter-condition/{id}")
	PokeCall<EncounterCondition> getEncounterCondition(
			@Path("id") @NonNull Integer id
	);

	@GET("encounter-condition/{name}")
	PokeCall<EncounterCondition> getEncounterCondition(
			@Path("name") @NonNull String name
	);

	@GET("encounter-condition-value/")
	PokeCall<ResourceList<EncounterConditionValue>> getEncounterConditionValueList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("encounter-condition-value/{id}")
	PokeCall<EncounterConditionValue> getEncounterConditionValue(
			@Path("id") @NonNull Integer id
	);

	@GET("encounter-condition-value/{name}")
	PokeCall<EncounterConditionValue> getEncounterConditionValue(
			@Path("name") @NonNull String name
	);

	@GET("evolution-chain/")
	PokeCall<ResourceList<EvolutionChain>> getEvolutionChainList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("evolution-chain/{id}")
	PokeCall<EvolutionChain> getEvolutionChain(
			@Path("id") @NonNull Integer id
	);

	@GET("evolution-trigger/")
	PokeCall<ResourceList<EvolutionTrigger>> getEvolutionTriggerList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("evolution-trigger/{id}")
	PokeCall<EvolutionTrigger> getEvolutionTrigger(
			@Path("id") @NonNull Integer id
	);

	@GET("evolution-trigger/{name}")
	PokeCall<EvolutionTrigger> getEvolutionTrigger(
			@Path("name") @NonNull String name
	);

	@GET("generation/")
	PokeCall<ResourceList<Generation>> getGenerationList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("generation/{id}")
	PokeCall<Generation> getGeneration(
			@Path("id") @NonNull Integer id
	);

	@GET("generation/{name}")
	PokeCall<Generation> getGeneration(
			@Path("name") @NonNull String name
	);

	@GET("pokedex/")
	PokeCall<ResourceList<Pokedex>> getPokedexList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokedex/{id}")
	PokeCall<Pokedex> getPokedex(
			@Path("id") @NonNull Integer id
	);

	@GET("pokedex/{name}")
	PokeCall<Pokedex> getPokedex(
			@Path("name") @NonNull String name
	);

	@GET("version/")
	PokeCall<ResourceList<Version>> getVersionList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("version/{id}")
	PokeCall<Version> getVersion(
			@Path("id") @NonNull Integer id
	);

	@GET("version/{name}")
	PokeCall<Version> getVersion(
			@Path("name") @NonNull String name
	);

	@GET("version-group/")
	PokeCall<ResourceList<VersionGroup>> getVersionGroupList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("version-group/{id}")
	PokeCall<VersionGroup> getVersionGroup(
			@Path("id") @NonNull Integer id
	);

	@GET("version-group/{name}")
	PokeCall<VersionGroup> getVersionGroup(
			@Path("name") @NonNull String name
	);

	@GET("item/")
	PokeCall<ResourceList<Item>> getItemList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("item/{id}")
	PokeCall<Item> getItem(
			@Path("id") @NonNull Integer id
	);

	@GET("item/{name}")
	PokeCall<Item> getItem(
			@Path("name") @NonNull String name
	);

	@GET("item-attribute/")
	PokeCall<ResourceList<ItemAttribute>> getItemAttributeList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("item-attribute/{id}")
	PokeCall<ItemAttribute> getItemAttribute(
			@Path("id") @NonNull Integer id
	);

	@GET("item-attribute/{name}")
	PokeCall<ItemAttribute> getItemAttribute(
			@Path("name") @NonNull String name
	);

	@GET("item-category/")
	PokeCall<ResourceList<ItemCategory>> getItemCategoryList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("item-category/{id}")
	PokeCall<ItemCategory> getItemCategory(
			@Path("id") @NonNull Integer id
	);

	@GET("item-category/{name}")
	PokeCall<ItemCategory> getItemCategory(
			@Path("name") @NonNull String name
	);

	@GET("item-fling-effect/")
	PokeCall<ResourceList<ItemFlingEffect>> getItemFlingEffectList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("item-fling-effect/{id}")
	PokeCall<ItemFlingEffect> getItemFlingEffect(
			@Path("id") @NonNull Integer id
	);

	@GET("item-fling-effect/{name}")
	PokeCall<ItemFlingEffect> getItemFlingEffect(
			@Path("name") @NonNull String name
	);

	@GET("item-pocket/")
	PokeCall<ResourceList<ItemPocket>> getItemPocketList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("item-pocket/{id}")
	PokeCall<ItemPocket> getItemPocket(
			@Path("id") @NonNull Integer id
	);

	@GET("item-pocket/{name}")
	PokeCall<ItemPocket> getItemPocket(
			@Path("name") @NonNull String name
	);

	@GET("location/")
	PokeCall<ResourceList<Location>> getLocationList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("location/{id}")
	PokeCall<Location> getLocation(
			@Path("id") @NonNull Integer id
	);

	@GET("location/{name}")
	PokeCall<Location> getLocation(
			@Path("name") @NonNull String name
	);

	@GET("location-area/")
	PokeCall<ResourceList<LocationArea>> getLocationAreaList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("location-area/{id}")
	PokeCall<LocationArea> getLocationArea(
			@Path("id") @NonNull Integer id
	);

	@GET("location-area/{name}")
	PokeCall<LocationArea> getLocationArea(
			@Path("name") @NonNull String name
	);

	@GET("pal-park-area/")
	PokeCall<ResourceList<PalParkArea>> getPalParkAreaList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pal-park-area/{id}")
	PokeCall<PalParkArea> getPalParkArea(
			@Path("id") @NonNull Integer id
	);

	@GET("pal-park-area/{name}")
	PokeCall<PalParkArea> getPalParkArea(
			@Path("name") @NonNull String name
	);

	@GET("region/")
	PokeCall<ResourceList<Region>> getRegionList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("region/{id}")
	PokeCall<Region> getRegion(
			@Path("id") @NonNull Integer id
	);

	@GET("region/{name}")
	PokeCall<Region> getRegion(
			@Path("name") @NonNull String name
	);

	@GET("machine/")
	PokeCall<ResourceList<Machine>> getMachineList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("machine/{id}")
	PokeCall<Machine> getMachine(
			@Path("id") @NonNull Integer id
	);

	@GET("move/")
	PokeCall<ResourceList<Move>> getMoveList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move/{id}")
	PokeCall<Move> getMove(
			@Path("id") @NonNull Integer id
	);

	@GET("move/{name}")
	PokeCall<Move> getMove(
			@Path("name") @NonNull String name
	);

	@GET("move-ailment/")
	PokeCall<ResourceList<MoveAilment>> getMoveAilmentList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-ailment/{id}")
	PokeCall<MoveAilment> getMoveAilment(
			@Path("id") @NonNull Integer id
	);

	@GET("move-ailment/{name}")
	PokeCall<MoveAilment> getMoveAilment(
			@Path("name") @NonNull String name
	);

	@GET("move-battle-style/")
	PokeCall<ResourceList<MoveBattleStyle>> getMoveBattleStyleList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-battle-style/{id}")
	PokeCall<MoveBattleStyle> getMoveBattleStyle(
			@Path("id") @NonNull Integer id
	);

	@GET("move-battle-style/{name}")
	PokeCall<MoveBattleStyle> getMoveBattleStyle(
			@Path("name") @NonNull String name
	);

	@GET("move-category/")
	PokeCall<ResourceList<MoveCategory>> getModelNameList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-category/{id}")
	PokeCall<MoveCategory> getModelName(
			@Path("id") @NonNull Integer id
	);

	@GET("move-category/{name}")
	PokeCall<MoveCategory> getModelName(
			@Path("name") @NonNull String name
	);

	@GET("move-damage-class/")
	PokeCall<ResourceList<MoveDamageClass>> getMoveDamageClassList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-damage-class/{id}")
	PokeCall<MoveDamageClass> getMoveDamageClass(
			@Path("id") @NonNull Integer id
	);

	@GET("move-damage-class/{name}")
	PokeCall<MoveDamageClass> getMoveDamageClass(
			@Path("name") @NonNull String name
	);

	@GET("move-learn-method/")
	PokeCall<ResourceList<MoveLearnMethod>> getMoveLearnMethodList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-learn-method/{id}")
	PokeCall<MoveLearnMethod> getMoveLearnMethod(
			@Path("id") @NonNull Integer id
	);

	@GET("move-learn-method/{name}")
	PokeCall<MoveLearnMethod> getMoveLearnMethod(
			@Path("name") @NonNull String name
	);

	@GET("move-target/")
	PokeCall<ResourceList<MoveTarget>> getMoveTargetList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("move-target/{id}")
	PokeCall<MoveTarget> getMoveTarget(
			@Path("id") @NonNull Integer id
	);

	@GET("move-target/{name}")
	PokeCall<MoveTarget> getMoveTarget(
			@Path("name") @NonNull String name
	);

	@GET("ability/")
	PokeCall<ResourceList<Ability>> getAbilityList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("ability/{id}")
	PokeCall<Ability> getAbility(
			@Path("id") @NonNull Integer id
	);

	@GET("ability/{name}")
	PokeCall<Ability> getAbility(
			@Path("name") @NonNull String name
	);

	@GET("characteristic/")
	PokeCall<ResourceList<Characteristic>> getCharacteristicList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("characteristic/{id}")
	PokeCall<Characteristic> getCharacteristic(
			@Path("id") @NonNull Integer id
	);

	@GET("egg-group/")
	PokeCall<ResourceList<EggGroup>> getEggGroupList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("egg-group/{id}")
	PokeCall<EggGroup> getEggGroup(
			@Path("id") @NonNull Integer id
	);

	@GET("egg-group/{name}")
	PokeCall<EggGroup> getEggGroup(
			@Path("name") @NonNull String name
	);

	@GET("gender/")
	PokeCall<ResourceList<Gender>> getGenderList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("gender/{id}")
	PokeCall<Gender> getGender(
			@Path("id") @NonNull Integer id
	);

	@GET("gender/{name}")
	PokeCall<Gender> getGender(
			@Path("name") @NonNull String name
	);

	@GET("growth-rate/")
	PokeCall<ResourceList<GrowthRate>> getGrowthRateList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("growth-rate/{id}")
	PokeCall<GrowthRate> getGrowthRate(
			@Path("id") @NonNull Integer id
	);

	@GET("growth-rate/{name}")
	PokeCall<GrowthRate> getGrowthRate(
			@Path("name") @NonNull String name
	);

	@GET("nature/")
	PokeCall<ResourceList<Nature>> getNatureList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("nature/{id}")
	PokeCall<Nature> getNature(
			@Path("id") @NonNull Integer id
	);

	@GET("nature/{name}")
	PokeCall<Nature> getNature(
			@Path("name") @NonNull String name
	);

	@GET("pokeathlon-stat/")
	PokeCall<ResourceList<PokeathlonStat>> getPokeathlonStatList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokeathlon-stat/{id}")
	PokeCall<PokeathlonStat> getPokeathlonStat(
			@Path("id") @NonNull Integer id
	);

	@GET("pokeathlon-stat/{name}")
	PokeCall<PokeathlonStat> getPokeathlonStat(
			@Path("name") @NonNull String name
	);

	@GET("pokemon/")
	PokeCall<ResourceList<Pokemon>> getPokemonList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon/{id}")
	PokeCall<Pokemon> getPokemon(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon/{name}")
	PokeCall<Pokemon> getPokemon(
			@Path("name") @NonNull String name
	);

	@GET("pokemon-color/")
	PokeCall<ResourceList<PokemonColor>> getPokemonColorList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon-color/{id}")
	PokeCall<PokemonColor> getPokemonColor(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon-color/{name}")
	PokeCall<PokemonColor> getPokemonColor(
			@Path("name") @NonNull String name
	);

	@GET("pokemon-form/")
	PokeCall<ResourceList<PokemonForm>> getPokemonFormList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon-form/{id}")
	PokeCall<PokemonForm> getPokemonForm(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon-form/{name}")
	PokeCall<PokemonForm> getPokemonForm(
			@Path("name") @NonNull String name
	);

	@GET("pokemon-habitat/")
	PokeCall<ResourceList<PokemonHabitat>> getPokemonHabitatList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon-habitat/{id}")
	PokeCall<PokemonHabitat> getPokemonHabitat(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon-habitat/{name}")
	PokeCall<PokemonHabitat> getPokemonHabitat(
			@Path("name") @NonNull String name
	);

	@GET("pokemon-shape/")
	PokeCall<ResourceList<PokemonShape>> getPokemonShapeList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon-shape/{id}")
	PokeCall<PokemonShape> getPokemonShape(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon-shape/{name}")
	PokeCall<PokemonShape> getPokemonShape(
			@Path("name") @NonNull String name
	);

	@GET("pokemon-species/")
	PokeCall<ResourceList<PokemonSpecies>> getPokemonSpeciesList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("pokemon-species/{id}")
	PokeCall<PokemonSpecies> getPokemonSpecies(
			@Path("id") @NonNull Integer id
	);

	@GET("pokemon-species/{name}")
	PokeCall<PokemonSpecies> getPokemonSpecies(
			@Path("name") @NonNull String name
	);

	@GET("stat/")
	PokeCall<ResourceList<Stat>> getStatList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("stat/{id}")
	PokeCall<Stat> getStat(
			@Path("id") @NonNull Integer id
	);

	@GET("stat/{name}")
	PokeCall<Stat> getStat(
			@Path("name") @NonNull String name
	);

	@GET("type/")
	PokeCall<ResourceList<Type>> getTypeList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("type/{id}")
	PokeCall<Type> getType(
			@Path("id") @NonNull Integer id
	);

	@GET("type/{name}")
	PokeCall<Type> getType(
			@Path("name") @NonNull String name
	);

	@GET("language/")
	PokeCall<ResourceList<Language>> getLanguageList(
			@Query("limit") @NonNull Integer limit,
			@Query("offset") @NonNull Integer offset
	);

	@GET("language/{id}")
	PokeCall<Language> getLanguage(
			@Path("id") @NonNull Integer id
	);

	@GET("language/{name}")
	PokeCall<Language> getLanguage(
			@Path("name") @NonNull String name
	);

}
