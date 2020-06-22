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
import com.xeroxparc.pokedex.data.entity.utility.common.APIResourceList;
import com.xeroxparc.pokedex.data.entity.utility.common.NamedAPIResourceList;
import com.xeroxparc.pokedex.data.entity.utility.language.Language;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeAPIService {

	@GET("berry/")
	Call<NamedAPIResourceList> getBerryInfoList(@Query("limit") Integer limit,
	                                            @Query("offset") Integer offset);

	@GET("berry/{id}")
	Call<Berry> getBerry(@Path("id") Integer id);

	@GET("berry/{name}")
	Call<Berry> getBerry(@Path("name") String name);

	@GET("berry-firmness/")
	Call<NamedAPIResourceList> getBerryFirmnessInfoList(@Query("limit") Integer limit,
	                                                    @Query("offset") Integer offset);

	@GET("berry-firmness/{id}")
	Call<BerryFirmness> getBerryFirmness(@Path("id") Integer id);

	@GET("berry-firmness/{name}")
	Call<BerryFirmness> getBerryFirmness(@Path("name") String name);

	@GET("berry-flavor/")
	Call<NamedAPIResourceList> getBerryFlavorInfoList(@Query("limit") Integer limit,
	                                                  @Query("offset") Integer offset);

	@GET("berry-flavor/{id}")
	Call<BerryFlavor> getBerryFlavor(@Path("id") Integer id);

	@GET("berry-flavor/{name}")
	Call<BerryFlavor> getBerryFlavor(@Path("name") String name);

	@GET("contest-type/")
	Call<NamedAPIResourceList> getContestTypeInfoList(@Query("limit") Integer limit,
	                                                  @Query("offset") Integer offset);

	@GET("contest-type/{id}")
	Call<ContestType> getContestType(@Path("id") Integer id);

	@GET("contest-type/{name}")
	Call<ContestType> getContestType(@Path("name") String name);

	@GET("contest-effect/")
	Call<APIResourceList> getContestEffectInfoList(@Query("limit") Integer limit,
	                                               @Query("offset") Integer offset);

	@GET("contest-effect/{id}")
	Call<ContestEffect> getContestEffect(@Path("id") Integer id);

	@GET("super-contest-effect/")
	Call<APIResourceList> getSuperContestEffectInfoList(@Query("limit") Integer limit,
	                                                    @Query("offset") Integer offset);

	@GET("super-contest-effect/{id}")
	Call<SuperContestEffect> getSuperContestEffect(@Path("id") Integer id);

	@GET("encounter-method/")
	Call<NamedAPIResourceList> getEncounterMethodInfoList(@Query("limit") Integer limit,
	                                                      @Query("offset") Integer offset);

	@GET("encounter-method/{id}")
	Call<EncounterMethod> getEncounterMethod(@Path("id") Integer id);

	@GET("encounter-method/{name}")
	Call<EncounterMethod> getEncounterMethod(@Path("name") String name);

	@GET("encounter-condition/")
	Call<NamedAPIResourceList> getEncounterConditionInfoList(@Query("limit") Integer limit,
	                                                         @Query("offset") Integer offset);

	@GET("encounter-condition/{id}")
	Call<EncounterCondition> getEncounterCondition(@Path("id") Integer id);

	@GET("encounter-condition/{name}")
	Call<EncounterCondition> getEncounterCondition(@Path("name") String name);

	@GET("encounter-condition-value/")
	Call<NamedAPIResourceList> getEncounterConditionValueInfoList(@Query("limit") Integer limit,
	                                                              @Query("offset") Integer offset);

	@GET("encounter-condition-value/{id}")
	Call<EncounterConditionValue> getEncounterConditionValue(@Path("id") Integer id);

	@GET("encounter-condition-value/{name}")
	Call<EncounterConditionValue> getEncounterConditionValue(@Path("name") String name);

	@GET("evolution-chain/")
	Call<APIResourceList> getEvolutionChainInfoList(@Query("limit") Integer limit,
	                                                @Query("offset") Integer offset);

	@GET("evolution-chain/{id}")
	Call<EvolutionChain> getEvolutionChain(@Path("id") Integer id);

	@GET("evolution-trigger/")
	Call<NamedAPIResourceList> getEvolutionTriggerInfoList(@Query("limit") Integer limit,
	                                                       @Query("offset") Integer offset);

	@GET("evolution-trigger/{id}")
	Call<EvolutionTrigger> getEvolutionTrigger(@Path("id") Integer id);

	@GET("evolution-trigger/{name}")
	Call<EvolutionTrigger> getEvolutionTrigger(@Path("name") String name);

	@GET("generation/")
	Call<NamedAPIResourceList> getGenerationInfoList(@Query("limit") Integer limit,
	                                                 @Query("offset") Integer offset);

	@GET("generation/{id}")
	Call<Generation> getGeneration(@Path("id") Integer id);

	@GET("generation/{name}")
	Call<Generation> getGeneration(@Path("name") String name);

	@GET("pokedex/")
	Call<NamedAPIResourceList> getPokedexInfoList(@Query("limit") Integer limit,
	                                              @Query("offset") Integer offset);

	@GET("pokedex/{id}")
	Call<Pokedex> getPokedex(@Path("id") Integer id);

	@GET("pokedex/{name}")
	Call<Pokedex> getPokedex(@Path("name") String name);

	@GET("version/")
	Call<NamedAPIResourceList> getVersionInfoList(@Query("limit") Integer limit,
	                                              @Query("offset") Integer offset);

	@GET("version/{id}")
	Call<Version> getVersion(@Path("id") Integer id);

	@GET("version/{name}")
	Call<Version> getVersion(@Path("name") String name);

	@GET("version-group/")
	Call<NamedAPIResourceList> getVersionGroupInfoList(@Query("limit") Integer limit,
	                                                   @Query("offset") Integer offset);

	@GET("version-group/{id}")
	Call<VersionGroup> getVersionGroup(@Path("id") Integer id);

	@GET("version-group/{name}")
	Call<VersionGroup> getVersionGroup(@Path("name") String name);

	@GET("item/")
	Call<NamedAPIResourceList> getItemInfoList(@Query("limit") Integer limit,
	                                           @Query("offset") Integer offset);

	@GET("item/{id}")
	Call<Item> getItem(@Path("id") Integer id);

	@GET("item/{name}")
	Call<Item> getItem(@Path("name") String name);

	@GET("item-attribute/")
	Call<NamedAPIResourceList> getItemAttributeInfoList(@Query("limit") Integer limit,
	                                                    @Query("offset") Integer offset);

	@GET("item-attribute/{id}")
	Call<ItemAttribute> getItemAttribute(@Path("id") Integer id);

	@GET("item-attribute/{name}")
	Call<ItemAttribute> getItemAttribute(@Path("name") String name);

	@GET("item-category/")
	Call<NamedAPIResourceList> getItemCategoryInfoList(@Query("limit") Integer limit,
	                                                   @Query("offset") Integer offset);

	@GET("item-category/{id}")
	Call<ItemCategory> getItemCategory(@Path("id") Integer id);

	@GET("item-category/{name}")
	Call<ItemCategory> getItemCategory(@Path("name") String name);

	@GET("item-fling-effect/")
	Call<NamedAPIResourceList> getItemFlingEffectInfoList(@Query("limit") Integer limit,
	                                                      @Query("offset") Integer offset);

	@GET("item-fling-effect/{id}")
	Call<ItemFlingEffect> getItemFlingEffect(@Path("id") Integer id);

	@GET("item-fling-effect/{name}")
	Call<ItemFlingEffect> getItemFlingEffect(@Path("name") String name);

	@GET("item-pocket/")
	Call<NamedAPIResourceList> getItemPocketInfoList(@Query("limit") Integer limit,
	                                                 @Query("offset") Integer offset);

	@GET("item-pocket/{id}")
	Call<ItemPocket> getItemPocket(@Path("id") Integer id);

	@GET("item-pocket/{name}")
	Call<ItemPocket> getItemPocket(@Path("name") String name);

	@GET("location/")
	Call<NamedAPIResourceList> getLocationInfoList(@Query("limit") Integer limit,
	                                               @Query("offset") Integer offset);

	@GET("location/{id}")
	Call<Location> getLocation(@Path("id") Integer id);

	@GET("location/{name}")
	Call<Location> getLocation(@Path("name") String name);

	@GET("location-area/")
	Call<NamedAPIResourceList> getLocationAreaInfoList(@Query("limit") Integer limit,
	                                                   @Query("offset") Integer offset);

	@GET("location-area/{id}")
	Call<LocationArea> getLocationArea(@Path("id") Integer id);

	@GET("location-area/{name}")
	Call<LocationArea> getLocationArea(@Path("name") String name);

	@GET("pal-park-area/")
	Call<NamedAPIResourceList> getPalParkAreaInfoList(@Query("limit") Integer limit,
	                                                  @Query("offset") Integer offset);

	@GET("pal-park-area/{id}")
	Call<PalParkArea> getPalParkArea(@Path("id") Integer id);

	@GET("pal-park-area/{name}")
	Call<PalParkArea> getPalParkArea(@Path("name") String name);

	@GET("region/")
	Call<NamedAPIResourceList> getRegionInfoList(@Query("limit") Integer limit,
	                                             @Query("offset") Integer offset);

	@GET("region/{id}")
	Call<Region> getRegion(@Path("id") Integer id);

	@GET("region/{name}")
	Call<Region> getRegion(@Path("name") String name);

	@GET("machine/")
	Call<APIResourceList> getMachineInfoList(@Query("limit") Integer limit,
	                                         @Query("offset") Integer offset);

	@GET("machine/{id}")
	Call<Machine> getMachine(@Path("id") Integer id);

	@GET("move/")
	Call<NamedAPIResourceList> getMoveInfoList(@Query("limit") Integer limit,
	                                           @Query("offset") Integer offset);

	@GET("move/{id}")
	Call<Move> getMove(@Path("id") Integer id);

	@GET("move/{name}")
	Call<Move> getMove(@Path("name") String name);

	@GET("move-ailment/")
	Call<NamedAPIResourceList> getMoveAilmentInfoList(@Query("limit") Integer limit,
	                                                  @Query("offset") Integer offset);

	@GET("move-ailment/{id}")
	Call<MoveAilment> getMoveAilment(@Path("id") Integer id);

	@GET("move-ailment/{name}")
	Call<MoveAilment> getMoveAilment(@Path("name") String name);

	@GET("move-battle-style/")
	Call<NamedAPIResourceList> getMoveBattleStyleInfoList(@Query("limit") Integer limit,
	                                                      @Query("offset") Integer offset);

	@GET("move-battle-style/{id}")
	Call<MoveBattleStyle> getMoveBattleStyle(@Path("id") Integer id);

	@GET("move-battle-style/{name}")
	Call<MoveBattleStyle> getMoveBattleStyle(@Path("name") String name);

	@GET("move-category/")
	Call<NamedAPIResourceList> getModelNameInfoList(@Query("limit") Integer limit,
	                                                @Query("offset") Integer offset);

	@GET("move-category/{id}")
	Call<ModelName> getModelName(@Path("id") Integer id);

	@GET("move-category/{name}")
	Call<ModelName> getModelName(@Path("name") String name);

	@GET("move-damage-class/")
	Call<NamedAPIResourceList> getMoveDamageClassInfoList(@Query("limit") Integer limit,
	                                                      @Query("offset") Integer offset);

	@GET("move-damage-class/{id}")
	Call<MoveDamageClass> getMoveDamageClass(@Path("id") Integer id);

	@GET("move-damage-class/{name}")
	Call<MoveDamageClass> getMoveDamageClass(@Path("name") String name);

	@GET("move-learn-method/")
	Call<NamedAPIResourceList> getMoveLearnMethodInfoList(@Query("limit") Integer limit,
	                                                      @Query("offset") Integer offset);

	@GET("move-learn-method/{id}")
	Call<MoveLearnMethod> getMoveLearnMethod(@Path("id") Integer id);

	@GET("move-learn-method/{name}")
	Call<MoveLearnMethod> getMoveLearnMethod(@Path("name") String name);

	@GET("move-target/")
	Call<NamedAPIResourceList> getMoveTargetInfoList(@Query("limit") Integer limit,
	                                                 @Query("offset") Integer offset);

	@GET("move-target/{id}")
	Call<MoveTarget> getMoveTarget(@Path("id") Integer id);

	@GET("move-target/{name}")
	Call<MoveTarget> getMoveTarget(@Path("name") String name);

	@GET("ability/")
	Call<NamedAPIResourceList> getAbilityInfoList(@Query("limit") Integer limit,
	                                              @Query("offset") Integer offset);

	@GET("ability/{id}")
	Call<Ability> getAbility(@Path("id") Integer id);

	@GET("ability/{name}")
	Call<Ability> getAbility(@Path("name") String name);

	@GET("characteristic/")
	Call<APIResourceList> getCharacteristicInfoList(@Query("limit") Integer limit,
	                                                @Query("offset") Integer offset);

	@GET("characteristic/{id}")
	Call<Characteristic> getCharacteristic(@Path("id") Integer id);

	@GET("egg-group/")
	Call<NamedAPIResourceList> getEggGroupInfoList(@Query("limit") Integer limit,
	                                               @Query("offset") Integer offset);

	@GET("egg-group/{id}")
	Call<EggGroup> getEggGroup(@Path("id") Integer id);

	@GET("egg-group/{name}")
	Call<EggGroup> getEggGroup(@Path("name") String name);

	@GET("gender/")
	Call<NamedAPIResourceList> getGenderInfoList(@Query("limit") Integer limit,
	                                             @Query("offset") Integer offset);

	@GET("gender/{id}")
	Call<Gender> getGender(@Path("id") Integer id);

	@GET("gender/{name}")
	Call<Gender> getGender(@Path("name") String name);

	@GET("growth-rate/")
	Call<NamedAPIResourceList> getGrowthRateInfoList(@Query("limit") Integer limit,
	                                                 @Query("offset") Integer offset);

	@GET("growth-rate/{id}")
	Call<GrowthRate> getGrowthRate(@Path("id") Integer id);

	@GET("growth-rate/{name}")
	Call<GrowthRate> getGrowthRate(@Path("name") String name);

	@GET("nature/")
	Call<NamedAPIResourceList> getNatureInfoList(@Query("limit") Integer limit,
	                                             @Query("offset") Integer offset);

	@GET("nature/{id}")
	Call<Nature> getNature(@Path("id") Integer id);

	@GET("nature/{name}")
	Call<Nature> getNature(@Path("name") String name);

	@GET("pokeathlon-stat/")
	Call<NamedAPIResourceList> getPokeathlonStatInfoList(@Query("limit") Integer limit,
	                                                     @Query("offset") Integer offset);

	@GET("pokeathlon-stat/{id}")
	Call<PokeathlonStat> getPokeathlonStat(@Path("id") Integer id);

	@GET("pokeathlon-stat/{name}")
	Call<PokeathlonStat> getPokeathlonStat(@Path("name") String name);

	@GET("pokemon/")
	Call<NamedAPIResourceList> getPokemonInfoList(@Query("limit") Integer limit,
	                                              @Query("offset") Integer offset);

	@GET("pokemon/{id}")
	Call<Pokemon> getPokemon(@Path("id") Integer id);

	@GET("pokemon/{name}")
	Call<Pokemon> getPokemon(@Path("name") String name);

	@GET("pokemon-color/")
	Call<NamedAPIResourceList> getPokemonColorInfoList(@Query("limit") Integer limit,
	                                                   @Query("offset") Integer offset);

	@GET("pokemon-color/{id}")
	Call<PokemonColor> getPokemonColor(@Path("id") Integer id);

	@GET("pokemon-color/{name}")
	Call<PokemonColor> getPokemonColor(@Path("name") String name);

	@GET("pokemon-form/")
	Call<NamedAPIResourceList> getPokemonFormInfoList(@Query("limit") Integer limit,
	                                                  @Query("offset") Integer offset);

	@GET("pokemon-form/{id}")
	Call<PokemonForm> getPokemonForm(@Path("id") Integer id);

	@GET("pokemon-form/{name}")
	Call<PokemonForm> getPokemonForm(@Path("name") String name);

	@GET("pokemon-habitat/")
	Call<NamedAPIResourceList> getPokemonHabitatInfoList(@Query("limit") Integer limit,
	                                                     @Query("offset") Integer offset);

	@GET("pokemon-habitat/{id}")
	Call<PokemonHabitat> getPokemonHabitat(@Path("id") Integer id);

	@GET("pokemon-habitat/{name}")
	Call<PokemonHabitat> getPokemonHabitat(@Path("name") String name);

	@GET("pokemon-shape/")
	Call<NamedAPIResourceList> getPokemonShapeInfoList(@Query("limit") Integer limit,
	                                                   @Query("offset") Integer offset);

	@GET("pokemon-shape/{id}")
	Call<PokemonShape> getPokemonShape(@Path("id") Integer id);

	@GET("pokemon-shape/{name}")
	Call<PokemonShape> getPokemonShape(@Path("name") String name);

	@GET("pokemon-species/")
	Call<NamedAPIResourceList> getPokemonSpeciesInfoList(@Query("limit") Integer limit,
	                                                     @Query("offset") Integer offset);

	@GET("pokemon-species/{id}")
	Call<PokemonSpecies> getPokemonSpecies(@Path("id") Integer id);

	@GET("pokemon-species/{name}")
	Call<PokemonSpecies> getPokemonSpecies(@Path("name") String name);

	@GET("stat/")
	Call<NamedAPIResourceList> getStatInfoList(@Query("limit") Integer limit,
	                                           @Query("offset") Integer offset);

	@GET("stat/{id}")
	Call<Stat> getStat(@Path("id") Integer id);

	@GET("stat/{name}")
	Call<Stat> getStat(@Path("name") String name);

	@GET("type/")
	Call<NamedAPIResourceList> getTypeInfoList(@Query("limit") Integer limit,
	                                           @Query("offset") Integer offset);

	@GET("type/{id}")
	Call<Type> getType(@Path("id") Integer id);

	@GET("type/{name}")
	Call<Type> getType(@Path("name") String name);

	@GET("language/")
	Call<NamedAPIResourceList> getLanguageInfoList(@Query("limit") Integer limit,
	                                               @Query("offset") Integer offset);

	@GET("language/{id}")
	Call<Language> getLanguage(@Path("id") Integer id);

	@GET("language/{name}")
	Call<Language> getLanguage(@Path("name") String name);

}
