package com.xeroxparc.pokedex.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
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
import com.xeroxparc.pokedex.data.model.utility.language.Language;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Access point to the PokeAPI services
 *
 * @author Fabio Buracchi
 */
public class PokeApiService {

	private static PokeApi service;

	public PokeApiService() {
		getService();
	}

	private synchronized void getService() {
		if (service == null) {
			service = new Retrofit.Builder()
					.baseUrl("https://pokeapi.co/api/v2/")
					.client(
							new OkHttpClient.Builder()
									.addInterceptor(new HttpLoggingInterceptor(
											s -> Log.d("API", s))
											.setLevel(HttpLoggingInterceptor.Level.BASIC)
									)
									.build()
					)
					.addConverterFactory(GsonConverterFactory.create(
							new GsonBuilder()
									.setFieldNamingPolicy(
											FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
									)
									.registerTypeAdapterFactory(
											new ResourceTypeAdapterFactory()
									)
									.create()
							)
					)
					.build()
					.create(PokeApi.class);
		}
	}

	private <T> T result(@NonNull Call<T> request) throws IOException, ApiError {
		Response<T> response = request.execute();
		if (response.isSuccessful()) {
			return response.body();
		} else {
			throw new ApiError(response.code(), response.message());
		}
	}

	public List<Berry> getBerryList(@NonNull Integer limit, @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getBerryList(limit, offset));
	}

	public Berry getBerry(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getBerry(id));
	}

	public List<BerryFirmness> getBerryFirmnessList(@NonNull Integer limit,
	                                                @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getBerryFirmnessList(limit, offset));
	}

	public BerryFirmness getBerryFirmness(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getBerryFirmness(id));
	}

	public List<BerryFlavor> getBerryFlavorList(@NonNull Integer limit,
	                                            @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getBerryFlavorList(limit, offset));
	}

	public BerryFlavor getBerryFlavor(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getBerryFlavor(id));
	}

	public List<ContestType> getContestTypeList(@NonNull Integer limit,
	                                            @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getContestTypeList(limit, offset));
	}

	public ContestType getContestType(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getContestType(id));
	}

	public List<ContestEffect> getContestEffectList(@NonNull Integer limit,
	                                                @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getContestEffectList(limit, offset));
	}

	public ContestEffect getContestEffect(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getContestEffect(id));
	}

	public List<SuperContestEffect> getSuperContestEffectList(@NonNull Integer limit,
	                                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getSuperContestEffectList(limit, offset));
	}

	public SuperContestEffect getSuperContestEffect(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getSuperContestEffect(id));
	}

	public List<EncounterMethod> getEncounterMethodList(@NonNull Integer limit,
	                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEncounterMethodList(limit, offset));
	}

	public EncounterMethod getEncounterMethod(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEncounterMethod(id));
	}

	public List<EncounterCondition> getEncounterConditionList(@NonNull Integer limit,
	                                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEncounterConditionList(limit, offset));
	}

	public EncounterCondition getEncounterCondition(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEncounterCondition(id));
	}

	public List<EncounterConditionValue> getEncounterConditionValueList(@NonNull Integer limit,
	                                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEncounterConditionValueList(limit, offset));
	}

	public EncounterConditionValue getEncounterConditionValue(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEncounterConditionValue(id));
	}

	public List<EvolutionChain> getEvolutionChainList(@NonNull Integer limit,
	                                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEvolutionChainList(limit, offset));
	}

	public EvolutionChain getEvolutionChain(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEvolutionChain(id));
	}

	public List<EvolutionTrigger> getEvolutionTriggerList(@NonNull Integer limit,
	                                                      @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEvolutionTriggerList(limit, offset));
	}

	public EvolutionTrigger getEvolutionTrigger(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEvolutionTrigger(id));
	}

	public List<Generation> getGenerationList(@NonNull Integer limit,
	                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getGenerationList(limit, offset));
	}

	public Generation getGeneration(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getGeneration(id));
	}

	public List<Pokedex> getPokedexList(@NonNull Integer limit,
	                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokedexList(limit, offset));
	}

	public Pokedex getPokedex(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokedex(id));
	}

	public List<Version> getVersionList(@NonNull Integer limit,
	                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getVersionList(limit, offset));
	}

	public Version getVersion(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getVersion(id));
	}

	public List<VersionGroup> getVersionGroupList(@NonNull Integer limit,
	                                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getVersionGroupList(limit, offset));
	}

	public VersionGroup getVersionGroup(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getVersionGroup(id));
	}

	public List<Item> getItemList(@NonNull Integer limit,
	                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getItemList(limit, offset));
	}

	public Item getItem(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getItem(id));
	}

	public List<ItemAttribute> getItemAttributeList(@NonNull Integer limit,
	                                                @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getItemAttributeList(limit, offset));
	}

	public ItemAttribute getItemAttribute(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getItemAttribute(id));
	}

	public List<ItemCategory> getItemCategoryList(@NonNull Integer limit,
	                                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getItemCategoryList(limit, offset));
	}

	public ItemCategory getItemCategory(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getItemCategory(id));
	}

	public List<ItemFlingEffect> getItemFlingEffectList(@NonNull Integer limit,
	                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getItemFlingEffectList(limit, offset));
	}

	public ItemFlingEffect getItemFlingEffect(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getItemFlingEffect(id));
	}

	public List<ItemPocket> getItemPocketList(@NonNull Integer limit,
	                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getItemPocketList(limit, offset));
	}

	public ItemPocket getItemPocket(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getItemPocket(id));
	}

	public List<Location> getLocationList(@NonNull Integer limit,
	                                      @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getLocationList(limit, offset));
	}

	public Location getLocation(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getLocation(id));
	}

	public List<LocationArea> getLocationAreaList(@NonNull Integer limit,
	                                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getLocationAreaList(limit, offset));
	}

	public LocationArea getLocationArea(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getLocationArea(id));
	}

	public List<PalParkArea> getPalParkAreaList(@NonNull Integer limit,
	                                            @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPalParkAreaList(limit, offset));
	}

	public PalParkArea getPalParkArea(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPalParkArea(id));
	}

	public List<Region> getRegionList(@NonNull Integer limit,
	                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getRegionList(limit, offset));
	}

	public Region getRegion(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getRegion(id));
	}

	public List<Machine> getMachineList(@NonNull Integer limit,
	                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMachineList(limit, offset));
	}

	public Machine getMachine(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMachine(id));
	}

	public List<Move> getMoveList(@NonNull Integer limit,
	                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveList(limit, offset));
	}

	public Move getMove(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMove(id));
	}

	public List<MoveAilment> getMoveAilmentList(@NonNull Integer limit,
	                                            @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveAilmentList(limit, offset));
	}

	public MoveAilment getMoveAilment(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMoveAilment(id));
	}

	public List<MoveBattleStyle> getMoveBattleStyleList(@NonNull Integer limit,
	                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveBattleStyleList(limit, offset));
	}

	public MoveBattleStyle getMoveBattleStyle(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMoveBattleStyle(id));
	}

	public List<MoveCategory> getModelNameList(@NonNull Integer limit,
	                                           @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getModelNameList(limit, offset));
	}

	public MoveCategory getModelName(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getModelName(id));
	}

	public List<MoveDamageClass> getMoveDamageClassList(@NonNull Integer limit,
	                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveDamageClassList(limit, offset));
	}

	public MoveDamageClass getMoveDamageClass(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMoveDamageClass(id));
	}

	public List<MoveLearnMethod> getMoveLearnMethodList(@NonNull Integer limit,
	                                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveLearnMethodList(limit, offset));
	}

	public MoveLearnMethod getMoveLearnMethod(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMoveLearnMethod(id));
	}

	public List<MoveTarget> getMoveTargetList(@NonNull Integer limit,
	                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getMoveTargetList(limit, offset));
	}

	public MoveTarget getMoveTarget(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getMoveTarget(id));
	}

	public List<Ability> getAbilityList(@NonNull Integer limit,
	                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getAbilityList(limit, offset));
	}

	public Ability getAbility(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getAbility(id));
	}

	public List<Characteristic> getCharacteristicList(@NonNull Integer limit,
	                                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getCharacteristicList(limit, offset));
	}

	public Characteristic getCharacteristic(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getCharacteristic(id));
	}

	public List<EggGroup> getEggGroupList(@NonNull Integer limit,
	                                      @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getEggGroupList(limit, offset));
	}

	public EggGroup getEggGroup(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getEggGroup(id));
	}

	public List<Gender> getGenderList(@NonNull Integer limit,
	                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getGenderList(limit, offset));
	}

	public Gender getGender(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getGender(id));
	}

	public List<GrowthRate> getGrowthRateList(@NonNull Integer limit,
	                                          @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getGrowthRateList(limit, offset));
	}

	public GrowthRate getGrowthRate(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getGrowthRate(id));
	}

	public List<Nature> getNatureList(@NonNull Integer limit,
	                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getNatureList(limit, offset));
	}

	public Nature getNature(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getNature(id));
	}

	public List<PokeathlonStat> getPokeathlonStatList(@NonNull Integer limit,
	                                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokeathlonStatList(limit, offset));
	}

	public PokeathlonStat getPokeathlonStat(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokeathlonStat(id));
	}

	public List<Pokemon> getPokemonList(@NonNull Integer limit,
	                                    @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonList(limit, offset));
	}

	public Pokemon getPokemon(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemon(id));
	}

	public List<PokemonColor> getPokemonColorList(@NonNull Integer limit,
	                                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonColorList(limit, offset));
	}

	public PokemonColor getPokemonColor(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemonColor(id));
	}

	public List<PokemonForm> getPokemonFormList(@NonNull Integer limit,
	                                            @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonFormList(limit, offset));
	}

	public PokemonForm getPokemonForm(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemonForm(id));
	}

	public List<PokemonHabitat> getPokemonHabitatList(@NonNull Integer limit,
	                                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonHabitatList(limit, offset));
	}

	public PokemonHabitat getPokemonHabitat(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemonHabitat(id));
	}

	public List<PokemonShape> getPokemonShapeList(@NonNull Integer limit,
	                                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonShapeList(limit, offset));
	}

	public PokemonShape getPokemonShape(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemonShape(id));
	}

	public List<PokemonSpecies> getPokemonSpeciesList(@NonNull Integer limit,
	                                                  @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getPokemonSpeciesList(limit, offset));
	}

	public PokemonSpecies getPokemonSpecies(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getPokemonSpecies(id));
	}

	public List<Stat> getStatList(@NonNull Integer limit,
	                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getStatList(limit, offset));
	}

	public Stat getStat(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getStat(id));
	}

	public List<Type> getTypeList(@NonNull Integer limit,
	                              @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getTypeList(limit, offset));
	}

	public Type getType(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getType(id));
	}

	public List<Language> getLanguageList(@NonNull Integer limit,
	                                      @NonNull Integer offset)
			throws IOException, ApiError {
		return result(service.getLanguageList(limit, offset));
	}

	public Language getLanguage(@NonNull Integer id)
			throws IOException, ApiError {
		return result(service.getLanguage(id));
	}

}
