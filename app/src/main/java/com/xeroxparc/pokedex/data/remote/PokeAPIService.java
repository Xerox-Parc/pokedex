package com.xeroxparc.pokedex.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
import com.xeroxparc.pokedex.data.model.evolutions.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.model.evolutions.trigger.EvolutionTrigger;
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

import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class PokeApiService {

	private static PokeApi service;

	public abstract void errorHandlerCallback();

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

	@NonNull
	private <T> LiveData<T> result(@NonNull Call<T> request) {
		MutableLiveData<T> result = new MutableLiveData<>();
		request.enqueue(new Callback<T>() {
			@Override
			public void onResponse(Call<T> call, Response<T> response) {
				if (response.isSuccessful()) {
					result.setValue(response.body());
				} else {
					Log.e("API", String.valueOf(response.code()));
					errorHandlerCallback();
				}
			}

			@Override
			public void onFailure(Call<T> call, Throwable t) {
				Log.e("API", Objects.requireNonNull(t.getMessage()));
				errorHandlerCallback();
			}
		});
		return result;
	}

	public LiveData<List<Berry>> getBerryList(@NonNull Integer limit, @NonNull Integer offset) {
		return result(service.getBerryList(limit, offset));
	}

	public LiveData<Berry> getBerry(@NonNull Integer id) {
		return result(service.getBerry(id));
	}

	public LiveData<List<BerryFirmness>> getBerryFirmnessList(@NonNull Integer limit,
	                                                          @NonNull Integer offset) {
		return result(service.getBerryFirmnessList(limit, offset));
	}

	public LiveData<BerryFirmness> getBerryFirmness(@NonNull Integer id) {
		return result(service.getBerryFirmness(id));
	}

	public LiveData<List<BerryFlavor>> getBerryFlavorList(@NonNull Integer limit,
	                                                      @NonNull Integer offset) {
		return result(service.getBerryFlavorList(limit, offset));
	}

	public LiveData<BerryFlavor> getBerryFlavor(@NonNull Integer id) {
		return result(service.getBerryFlavor(id));
	}

	public LiveData<List<ContestType>> getContestTypeList(@NonNull Integer limit,
	                                                      @NonNull Integer offset) {
		return result(service.getContestTypeList(limit, offset));
	}

	public LiveData<ContestType> getContestType(@NonNull Integer id) {
		return result(service.getContestType(id));
	}

	public LiveData<List<ContestEffect>> getContestEffectList(@NonNull Integer limit,
	                                                          @NonNull Integer offset) {
		return result(service.getContestEffectList(limit, offset));
	}

	public LiveData<ContestEffect> getContestEffect(@NonNull Integer id) {
		return result(service.getContestEffect(id));
	}

	public LiveData<List<SuperContestEffect>> getSuperContestEffectList(@NonNull Integer limit,
	                                                                    @NonNull Integer offset) {
		return result(service.getSuperContestEffectList(limit, offset));
	}

	public LiveData<SuperContestEffect> getSuperContestEffect(@NonNull Integer id) {
		return result(service.getSuperContestEffect(id));
	}

	public LiveData<List<EncounterMethod>> getEncounterMethodList(@NonNull Integer limit,
	                                                              @NonNull Integer offset) {
		return result(service.getEncounterMethodList(limit, offset));
	}

	public LiveData<EncounterMethod> getEncounterMethod(@NonNull Integer id) {
		return result(service.getEncounterMethod(id));
	}

	public LiveData<List<EncounterCondition>> getEncounterConditionList(@NonNull Integer limit,
	                                                                    @NonNull Integer offset) {
		return result(service.getEncounterConditionList(limit, offset));
	}

	public LiveData<EncounterCondition> getEncounterCondition(@NonNull Integer id) {
		return result(service.getEncounterCondition(id));
	}

	public LiveData<List<EncounterConditionValue>> getEncounterConditionValueList(@NonNull Integer limit,
	                                                                              @NonNull Integer offset) {
		return result(service.getEncounterConditionValueList(limit, offset));
	}

	public LiveData<EncounterConditionValue> getEncounterConditionValue(@NonNull Integer id) {
		return result(service.getEncounterConditionValue(id));
	}

	public LiveData<List<EvolutionChain>> getEvolutionChainList(@NonNull Integer limit,
	                                                            @NonNull Integer offset) {
		return result(service.getEvolutionChainList(limit, offset));
	}

	public LiveData<EvolutionChain> getEvolutionChain(@NonNull Integer id) {
		return result(service.getEvolutionChain(id));
	}

	public LiveData<List<EvolutionTrigger>> getEvolutionTriggerList(@NonNull Integer limit,
	                                                                @NonNull Integer offset) {
		return result(service.getEvolutionTriggerList(limit, offset));
	}

	public LiveData<EvolutionTrigger> getEvolutionTrigger(@NonNull Integer id) {
		return result(service.getEvolutionTrigger(id));
	}

	public LiveData<List<Generation>> getGenerationList(@NonNull Integer limit,
	                                                    @NonNull Integer offset) {
		return result(service.getGenerationList(limit, offset));
	}

	public LiveData<Generation> getGeneration(@NonNull Integer id) {
		return result(service.getGeneration(id));
	}

	public LiveData<List<Pokedex>> getPokedexList(@NonNull Integer limit,
	                                              @NonNull Integer offset) {
		return result(service.getPokedexList(limit, offset));
	}

	public LiveData<Pokedex> getPokedex(@NonNull Integer id) {
		return result(service.getPokedex(id));
	}

	public LiveData<List<Version>> getVersionList(@NonNull Integer limit,
	                                              @NonNull Integer offset) {
		return result(service.getVersionList(limit, offset));
	}

	public LiveData<Version> getVersion(@NonNull Integer id) {
		return result(service.getVersion(id));
	}

	public LiveData<List<VersionGroup>> getVersionGroupList(@NonNull Integer limit,
	                                                        @NonNull Integer offset) {
		return result(service.getVersionGroupList(limit, offset));
	}

	public LiveData<VersionGroup> getVersionGroup(@NonNull Integer id) {
		return result(service.getVersionGroup(id));
	}

	public LiveData<List<Item>> getItemList(@NonNull Integer limit,
	                                        @NonNull Integer offset) {
		return result(service.getItemList(limit, offset));
	}

	public LiveData<Item> getItem(@NonNull Integer id) {
		return result(service.getItem(id));
	}

	public LiveData<List<ItemAttribute>> getItemAttributeList(@NonNull Integer limit,
	                                                          @NonNull Integer offset) {
		return result(service.getItemAttributeList(limit, offset));
	}

	public LiveData<ItemAttribute> getItemAttribute(@NonNull Integer id) {
		return result(service.getItemAttribute(id));
	}

	public LiveData<List<ItemCategory>> getItemCategoryList(@NonNull Integer limit,
	                                                        @NonNull Integer offset) {
		return result(service.getItemCategoryList(limit, offset));
	}

	public LiveData<ItemCategory> getItemCategory(@NonNull Integer id) {
		return result(service.getItemCategory(id));
	}

	public LiveData<List<ItemFlingEffect>> getItemFlingEffectList(@NonNull Integer limit,
	                                                              @NonNull Integer offset) {
		return result(service.getItemFlingEffectList(limit, offset));
	}

	public LiveData<ItemFlingEffect> getItemFlingEffect(@NonNull Integer id) {
		return result(service.getItemFlingEffect(id));
	}

	public LiveData<List<ItemPocket>> getItemPocketList(@NonNull Integer limit,
	                                                    @NonNull Integer offset) {
		return result(service.getItemPocketList(limit, offset));
	}

	public LiveData<ItemPocket> getItemPocket(@NonNull Integer id) {
		return result(service.getItemPocket(id));
	}

	public LiveData<List<Location>> getLocationList(@NonNull Integer limit,
	                                                @NonNull Integer offset) {
		return result(service.getLocationList(limit, offset));
	}

	public LiveData<Location> getLocation(@NonNull Integer id) {
		return result(service.getLocation(id));
	}

	public LiveData<List<LocationArea>> getLocationAreaList(@NonNull Integer limit,
	                                                        @NonNull Integer offset) {
		return result(service.getLocationAreaList(limit, offset));
	}

	public LiveData<LocationArea> getLocationArea(@NonNull Integer id) {
		return result(service.getLocationArea(id));
	}

	public LiveData<List<PalParkArea>> getPalParkAreaList(@NonNull Integer limit,
	                                                      @NonNull Integer offset) {
		return result(service.getPalParkAreaList(limit, offset));
	}

	public LiveData<PalParkArea> getPalParkArea(@NonNull Integer id) {
		return result(service.getPalParkArea(id));
	}

	public LiveData<List<Region>> getRegionList(@NonNull Integer limit,
	                                            @NonNull Integer offset) {
		return result(service.getRegionList(limit, offset));
	}

	public LiveData<Region> getRegion(@NonNull Integer id) {
		return result(service.getRegion(id));
	}

	public LiveData<List<Machine>> getMachineList(@NonNull Integer limit,
	                                              @NonNull Integer offset) {
		return result(service.getMachineList(limit, offset));
	}

	public LiveData<Machine> getMachine(@NonNull Integer id) {
		return result(service.getMachine(id));
	}

	public LiveData<List<Move>> getMoveList(@NonNull Integer limit,
	                                        @NonNull Integer offset) {
		return result(service.getMoveList(limit, offset));
	}

	public LiveData<Move> getMove(@NonNull Integer id) {
		return result(service.getMove(id));
	}

	public LiveData<List<MoveAilment>> getMoveAilmentList(@NonNull Integer limit,
	                                                      @NonNull Integer offset) {
		return result(service.getMoveAilmentList(limit, offset));
	}

	public LiveData<MoveAilment> getMoveAilment(@NonNull Integer id) {
		return result(service.getMoveAilment(id));
	}

	public LiveData<List<MoveBattleStyle>> getMoveBattleStyleList(@NonNull Integer limit,
	                                                              @NonNull Integer offset) {
		return result(service.getMoveBattleStyleList(limit, offset));
	}

	public LiveData<MoveBattleStyle> getMoveBattleStyle(@NonNull Integer id) {
		return result(service.getMoveBattleStyle(id));
	}

	public LiveData<List<MoveCategory>> getModelNameList(@NonNull Integer limit,
	                                                     @NonNull Integer offset) {
		return result(service.getModelNameList(limit, offset));
	}

	public LiveData<MoveCategory> getModelName(@NonNull Integer id) {
		return result(service.getModelName(id));
	}

	public LiveData<List<MoveDamageClass>> getMoveDamageClassList(@NonNull Integer limit,
	                                                              @NonNull Integer offset) {
		return result(service.getMoveDamageClassList(limit, offset));
	}

	public LiveData<MoveDamageClass> getMoveDamageClass(@NonNull Integer id) {
		return result(service.getMoveDamageClass(id));
	}

	public LiveData<List<MoveLearnMethod>> getMoveLearnMethodList(@NonNull Integer limit,
	                                                              @NonNull Integer offset) {
		return result(service.getMoveLearnMethodList(limit, offset));
	}

	public LiveData<MoveLearnMethod> getMoveLearnMethod(@NonNull Integer id) {
		return result(service.getMoveLearnMethod(id));
	}

	public LiveData<List<MoveTarget>> getMoveTargetList(@NonNull Integer limit,
	                                                    @NonNull Integer offset) {
		return result(service.getMoveTargetList(limit, offset));
	}

	public LiveData<MoveTarget> getMoveTarget(@NonNull Integer id) {
		return result(service.getMoveTarget(id));
	}

	public LiveData<List<Ability>> getAbilityList(@NonNull Integer limit,
	                                              @NonNull Integer offset) {
		return result(service.getAbilityList(limit, offset));
	}

	public LiveData<Ability> getAbility(@NonNull Integer id) {
		return result(service.getAbility(id));
	}

	public LiveData<List<Characteristic>> getCharacteristicList(@NonNull Integer limit,
	                                                            @NonNull Integer offset) {
		return result(service.getCharacteristicList(limit, offset));
	}

	public LiveData<Characteristic> getCharacteristic(@NonNull Integer id) {
		return result(service.getCharacteristic(id));
	}

	public LiveData<List<EggGroup>> getEggGroupList(@NonNull Integer limit,
	                                                @NonNull Integer offset) {
		return result(service.getEggGroupList(limit, offset));
	}

	public LiveData<EggGroup> getEggGroup(@NonNull Integer id) {
		return result(service.getEggGroup(id));
	}

	public LiveData<List<Gender>> getGenderList(@NonNull Integer limit,
	                                            @NonNull Integer offset) {
		return result(service.getGenderList(limit, offset));
	}

	public LiveData<Gender> getGender(@NonNull Integer id) {
		return result(service.getGender(id));
	}

	public LiveData<List<GrowthRate>> getGrowthRateList(@NonNull Integer limit,
	                                                    @NonNull Integer offset) {
		return result(service.getGrowthRateList(limit, offset));
	}

	public LiveData<GrowthRate> getGrowthRate(@NonNull Integer id) {
		return result(service.getGrowthRate(id));
	}

	public LiveData<List<Nature>> getNatureList(@NonNull Integer limit,
	                                            @NonNull Integer offset) {
		return result(service.getNatureList(limit, offset));
	}

	public LiveData<Nature> getNature(@NonNull Integer id) {
		return result(service.getNature(id));
	}

	public LiveData<List<PokeathlonStat>> getPokeathlonStatList(@NonNull Integer limit,
	                                                            @NonNull Integer offset) {
		return result(service.getPokeathlonStatList(limit, offset));
	}

	public LiveData<PokeathlonStat> getPokeathlonStat(@NonNull Integer id) {
		return result(service.getPokeathlonStat(id));
	}

	public LiveData<List<Pokemon>> getPokemonList(@NonNull Integer limit,
	                                              @NonNull Integer offset) {
		return result(service.getPokemonList(limit, offset));
	}

	public LiveData<Pokemon> getPokemon(@NonNull Integer id) {
		return result(service.getPokemon(id));
	}

	public LiveData<List<PokemonColor>> getPokemonColorList(@NonNull Integer limit,
	                                                        @NonNull Integer offset) {
		return result(service.getPokemonColorList(limit, offset));
	}

	public LiveData<PokemonColor> getPokemonColor(@NonNull Integer id) {
		return result(service.getPokemonColor(id));
	}

	public LiveData<List<PokemonForm>> getPokemonFormList(@NonNull Integer limit,
	                                                      @NonNull Integer offset) {
		return result(service.getPokemonFormList(limit, offset));
	}

	public LiveData<PokemonForm> getPokemonForm(@NonNull Integer id) {
		return result(service.getPokemonForm(id));
	}

	public LiveData<List<PokemonHabitat>> getPokemonHabitatList(@NonNull Integer limit,
	                                                            @NonNull Integer offset) {
		return result(service.getPokemonHabitatList(limit, offset));
	}

	public LiveData<PokemonHabitat> getPokemonHabitat(@NonNull Integer id) {
		return result(service.getPokemonHabitat(id));
	}

	public LiveData<List<PokemonShape>> getPokemonShapeList(@NonNull Integer limit,
	                                                        @NonNull Integer offset) {
		return result(service.getPokemonShapeList(limit, offset));
	}

	public LiveData<PokemonShape> getPokemonShape(@NonNull Integer id) {
		return result(service.getPokemonShape(id));
	}

	public LiveData<List<PokemonSpecies>> getPokemonSpeciesList(@NonNull Integer limit,
	                                                            @NonNull Integer offset) {
		return result(service.getPokemonSpeciesList(limit, offset));
	}

	public LiveData<PokemonSpecies> getPokemonSpecies(@NonNull Integer id) {
		return result(service.getPokemonSpecies(id));
	}

	public LiveData<List<Stat>> getStatList(@NonNull Integer limit,
	                                        @NonNull Integer offset) {
		return result(service.getStatList(limit, offset));
	}

	public LiveData<Stat> getStat(@NonNull Integer id) {
		return result(service.getStat(id));
	}

	public LiveData<List<Type>> getTypeList(@NonNull Integer limit,
	                                        @NonNull Integer offset) {
		return result(service.getTypeList(limit, offset));
	}

	public LiveData<Type> getType(@NonNull Integer id) {
		return result(service.getType(id));
	}

	public LiveData<List<Language>> getLanguageList(@NonNull Integer limit,
	                                                @NonNull Integer offset) {
		return result(service.getLanguageList(limit, offset));
	}

	public LiveData<Language> getLanguage(@NonNull Integer id) {
		return result(service.getLanguage(id));
	}

}
