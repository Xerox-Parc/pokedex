package com.xeroxparc.pokedex.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xeroxparc.pokedex.data.model.berry.Berry;
import com.xeroxparc.pokedex.data.model.berry.BerryFlavorMap;
import com.xeroxparc.pokedex.data.model.berry.firmness.BerryFirmness;
import com.xeroxparc.pokedex.data.model.berry.flavor.BerryFlavor;
import com.xeroxparc.pokedex.data.model.berry.flavor.FlavorBerryMap;
import com.xeroxparc.pokedex.data.model.contest.effect.ContestEffect;
import com.xeroxparc.pokedex.data.model.contest.supereffect.SuperContestEffect;
import com.xeroxparc.pokedex.data.model.contest.type.ContestName;
import com.xeroxparc.pokedex.data.model.contest.type.ContestType;
import com.xeroxparc.pokedex.data.model.encounter.condition.EncounterCondition;
import com.xeroxparc.pokedex.data.model.encounter.conditionvalue.EncounterConditionValue;
import com.xeroxparc.pokedex.data.model.evolution.chain.ChainLink;
import com.xeroxparc.pokedex.data.model.evolution.chain.EvolutionChain;
import com.xeroxparc.pokedex.data.model.game.generation.Generation;
import com.xeroxparc.pokedex.data.model.game.pokedex.Pokedex;
import com.xeroxparc.pokedex.data.model.game.pokedex.PokemonEntry;
import com.xeroxparc.pokedex.data.model.game.version.Version;
import com.xeroxparc.pokedex.data.model.game.versiongroup.VersionGroup;
import com.xeroxparc.pokedex.data.model.item.Item;
import com.xeroxparc.pokedex.data.model.item.ItemHolderPokemon;
import com.xeroxparc.pokedex.data.model.item.ItemSprites;
import com.xeroxparc.pokedex.data.model.item.attribute.ItemAttribute;
import com.xeroxparc.pokedex.data.model.item.category.ItemCategory;
import com.xeroxparc.pokedex.data.model.item.effect.ItemFlingEffect;
import com.xeroxparc.pokedex.data.model.item.pocket.ItemPocket;
import com.xeroxparc.pokedex.data.model.location.Location;
import com.xeroxparc.pokedex.data.model.location.area.EncounterMethodRate;
import com.xeroxparc.pokedex.data.model.location.area.LocationArea;
import com.xeroxparc.pokedex.data.model.location.area.PokemonEncounter;
import com.xeroxparc.pokedex.data.model.location.palparckarea.PalParkEncounterSpecies;
import com.xeroxparc.pokedex.data.model.location.region.Region;
import com.xeroxparc.pokedex.data.model.move.ContestComboSet;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.move.MoveFlavorText;
import com.xeroxparc.pokedex.data.model.move.MoveMetaData;
import com.xeroxparc.pokedex.data.model.move.MoveStatChange;
import com.xeroxparc.pokedex.data.model.move.PastMoveStatValues;
import com.xeroxparc.pokedex.data.model.move.damageclass.MoveDamageClass;
import com.xeroxparc.pokedex.data.model.move.learnmethod.MoveLearnMethod;
import com.xeroxparc.pokedex.data.model.move.target.MoveTarget;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonAbility;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonHeldItem;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonMove;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonSprites;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonStat;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.model.pokemon.ability.Ability;
import com.xeroxparc.pokedex.data.model.pokemon.ability.AbilityEffectChange;
import com.xeroxparc.pokedex.data.model.pokemon.ability.AbilityFlavorText;
import com.xeroxparc.pokedex.data.model.pokemon.ability.AbilityPokemon;
import com.xeroxparc.pokedex.data.model.pokemon.characteristic.Characteristic;
import com.xeroxparc.pokedex.data.model.pokemon.color.PokemonColor;
import com.xeroxparc.pokedex.data.model.pokemon.egggroup.EggGroup;
import com.xeroxparc.pokedex.data.model.pokemon.form.PokemonForm;
import com.xeroxparc.pokedex.data.model.pokemon.form.PokemonFormSprites;
import com.xeroxparc.pokedex.data.model.pokemon.gender.PokemonSpeciesGender;
import com.xeroxparc.pokedex.data.model.pokemon.growthrate.GrowthRate;
import com.xeroxparc.pokedex.data.model.pokemon.growthrate.GrowthRateExperienceLevel;
import com.xeroxparc.pokedex.data.model.pokemon.habitat.PokemonHabitat;
import com.xeroxparc.pokedex.data.model.pokemon.nature.MoveBattleStylePreference;
import com.xeroxparc.pokedex.data.model.pokemon.nature.NatureStatChange;
import com.xeroxparc.pokedex.data.model.pokemon.pokeathlonstats.NaturePokeathlonStatAffectSets;
import com.xeroxparc.pokedex.data.model.pokemon.shape.AwesomeName;
import com.xeroxparc.pokedex.data.model.pokemon.shape.PokemonShape;
import com.xeroxparc.pokedex.data.model.pokemon.species.Genus;
import com.xeroxparc.pokedex.data.model.pokemon.species.PalParkEncounterArea;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpeciesDexEntry;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpeciesVariety;
import com.xeroxparc.pokedex.data.model.pokemon.stats.MoveStatAffectSets;
import com.xeroxparc.pokedex.data.model.pokemon.stats.NatureStatAffectSets;
import com.xeroxparc.pokedex.data.model.pokemon.stats.Stat;
import com.xeroxparc.pokedex.data.model.pokemon.type.Type;
import com.xeroxparc.pokedex.data.model.pokemon.type.TypePokemon;
import com.xeroxparc.pokedex.data.model.pokemon.type.TypeRelations;
import com.xeroxparc.pokedex.data.model.utility.common.Description;
import com.xeroxparc.pokedex.data.model.utility.common.Effect;
import com.xeroxparc.pokedex.data.model.utility.common.FlavorText;
import com.xeroxparc.pokedex.data.model.utility.common.GenerationGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.MachineVersionDetail;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;
import com.xeroxparc.pokedex.data.model.utility.common.VersionGameIndex;
import com.xeroxparc.pokedex.data.model.utility.common.VersionGroupFlavorText;

import java.util.List;

/**
 * Set of converters to store data in the database as JSON strings to reduce model complexity
 *
 * @author Fabio Buracchi
 */
public class Converters {

	private static Gson gson = new Gson();

	@TypeConverter
	public String fromIntegerList(List<Integer> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Integer> toIntegerList(String json) {
		return gson.fromJson(json, new TypeToken<List<Integer>>(){}.getType());
	}

	@TypeConverter
	public String fromBerryList(List<Berry> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Berry> toBerryList(String json) {
		return gson.fromJson(json, new TypeToken<List<Berry>>(){}.getType());
	}

	@TypeConverter
	public String fromFlavorBerryMapList(List<FlavorBerryMap> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<FlavorBerryMap> toFlavorBerryMapList(String json) {
		return gson.fromJson(json, new TypeToken<List<FlavorBerryMap>>(){}.getType());
	}

	@TypeConverter
	public String fromBerryFlavorMapList(List<BerryFlavorMap> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<BerryFlavorMap> toBerryFlavorMapList(String json) {
		return gson.fromJson(json, new TypeToken<List<BerryFlavorMap>>(){}.getType());
	}

	@TypeConverter
	public String fromBerryFirmness(BerryFirmness value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public BerryFirmness toBerryFirmness(String json) {
		return gson.fromJson(json, new TypeToken<BerryFirmness>(){}.getType());
	}

	@TypeConverter
	public String fromBerryFlavor(BerryFlavor value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public BerryFlavor toBerryFlavor(String json) {
		return gson.fromJson(json, new TypeToken<BerryFlavor>(){}.getType());
	}

	@TypeConverter
	public String fromContestEffect(ContestEffect value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ContestEffect toContestEffect(String json) {
		return gson.fromJson(json, new TypeToken<ContestEffect>(){}.getType());
	}

	@TypeConverter
	public String fromSuperContestEffect(SuperContestEffect value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public SuperContestEffect toSuperContestEffect(String json) {
		return gson.fromJson(json, new TypeToken<SuperContestEffect>(){}.getType());
	}

	@TypeConverter
	public String fromContestType(ContestType value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ContestType toContestType(String json) {
		return gson.fromJson(json, new TypeToken<ContestType>(){}.getType());
	}

	@TypeConverter
	public String fromContestNameList(List<ContestName> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<ContestName> toContestNameList(String json) {
		return gson.fromJson(json, new TypeToken<List<ContestName>>(){}.getType());
	}

	@TypeConverter
	public String fromEncounterConditionValueList(List<EncounterConditionValue> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<EncounterConditionValue> toEncounterConditionValueList(String json) {
		return gson.fromJson(json, new TypeToken<List<EncounterConditionValue>>(){}.getType());
	}

	@TypeConverter
	public String fromEncounterCondition(EncounterCondition value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public EncounterCondition toEncounterCondition(String json) {
		return gson.fromJson(json, new TypeToken<EncounterCondition>(){}.getType());
	}

	@TypeConverter
	public String fromChainLink(ChainLink value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ChainLink toChainLink(String json) {
		return gson.fromJson(json, new TypeToken<ChainLink>(){}.getType());
	}

	@TypeConverter
	public String fromEvolutionChain(EvolutionChain value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public EvolutionChain toEvolutionChain(String json) {
		return gson.fromJson(json, new TypeToken<EvolutionChain>(){}.getType());
	}

	@TypeConverter
	public String fromGeneration(Generation value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Generation toGeneration(String json) {
		return gson.fromJson(json, new TypeToken<Generation>(){}.getType());
	}

	@TypeConverter
	public String fromPokedexList(List<Pokedex> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Pokedex> toPokedexList(String json) {
		return gson.fromJson(json, new TypeToken<List<Pokedex>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonEntryList(List<PokemonEntry> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonEntry> toPokemonEntryList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonEntry>>(){}.getType());
	}

	@TypeConverter
	public String fromVersionList(List<Version> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Version> toVersionList(String json) {
		return gson.fromJson(json, new TypeToken<List<Version>>(){}.getType());
	}

	@TypeConverter
	public String fromVersionGroup(VersionGroup value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public VersionGroup toVersionGroup(String json) {
		return gson.fromJson(json, new TypeToken<VersionGroup>(){}.getType());
	}

	@TypeConverter
	public String fromVersionGroupList(List<VersionGroup> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<VersionGroup> toVersionGroupList(String json) {
		return gson.fromJson(json, new TypeToken<List<VersionGroup>>(){}.getType());
	}

	@TypeConverter
	public String fromItem(Item value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Item toItem(String json) {
		return gson.fromJson(json, new TypeToken<Item>(){}.getType());
	}

	@TypeConverter
	public String fromItemList(List<Item> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Item> toItemList(String json) {
		return gson.fromJson(json, new TypeToken<List<Item>>(){}.getType());
	}

	@TypeConverter
	public String fromItemHolderPokemonList(List<ItemHolderPokemon> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<ItemHolderPokemon> toItemHolderPokemonList(String json) {
		return gson.fromJson(json, new TypeToken<List<ItemHolderPokemon>>(){}.getType());
	}

	@TypeConverter
	public String fromItemSprites(ItemSprites value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ItemSprites toItemSprites(String json) {
		return gson.fromJson(json, new TypeToken<ItemSprites>(){}.getType());
	}

	@TypeConverter
	public String fromItemAttributeList(List<ItemAttribute> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<ItemAttribute> toItemAttributeList(String json) {
		return gson.fromJson(json, new TypeToken<List<ItemAttribute>>(){}.getType());
	}

	@TypeConverter
	public String fromItemCategory(ItemCategory value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ItemCategory toItemCategory(String json) {
		return gson.fromJson(json, new TypeToken<ItemCategory>(){}.getType());
	}

	@TypeConverter
	public String fromItemCategoryList(List<ItemCategory> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<ItemCategory> toItemCategoryList(String json) {
		return gson.fromJson(json, new TypeToken<List<ItemCategory>>(){}.getType());
	}

	@TypeConverter
	public String fromItemFlingEffect(ItemFlingEffect value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ItemFlingEffect toItemFlingEffect(String json) {
		return gson.fromJson(json, new TypeToken<ItemFlingEffect>(){}.getType());
	}

	@TypeConverter
	public String fromItemPocket(ItemPocket value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ItemPocket toItemPocket(String json) {
		return gson.fromJson(json, new TypeToken<ItemPocket>(){}.getType());
	}

	@TypeConverter
	public String fromLocation(Location value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Location toLocation(String json) {
		return gson.fromJson(json, new TypeToken<Location>(){}.getType());
	}

	@TypeConverter
	public String fromLocationList(List<Location> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Location> toLocationList(String json) {
		return gson.fromJson(json, new TypeToken<List<Location>>(){}.getType());
	}

	@TypeConverter
	public String fromLocationAreaList(List<LocationArea> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<LocationArea> toLocationAreaList(String json) {
		return gson.fromJson(json, new TypeToken<List<LocationArea>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonEncounterList(List<PokemonEncounter> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonEncounter> toPokemonEncounterList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonEncounter>>(){}.getType());
	}

	@TypeConverter
	public String fromEncounterMethodRateList(List<EncounterMethodRate> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<EncounterMethodRate> toEncounterMethodRateList(String json) {
		return gson.fromJson(json, new TypeToken<List<EncounterMethodRate>>(){}.getType());
	}

	@TypeConverter
	public String fromPalParkEncounterSpeciesList(List<PalParkEncounterSpecies> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PalParkEncounterSpecies> toPalParkEncounterSpeciesList(String json) {
		return gson.fromJson(json, new TypeToken<List<PalParkEncounterSpecies>>(){}.getType());
	}

	@TypeConverter
	public String fromRegion(Region value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Region toRegion(String json) {
		return gson.fromJson(json, new TypeToken<Region>(){}.getType());
	}

	@TypeConverter
	public String fromRegionList(List<Region> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Region> toRegionList(String json) {
		return gson.fromJson(json, new TypeToken<List<Region>>(){}.getType());
	}

	@TypeConverter
	public String fromMachineVersionDetailList(List<MachineVersionDetail> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<MachineVersionDetail> toMachineVersionDetailList(String json) {
		return gson.fromJson(json, new TypeToken<List<MachineVersionDetail>>(){}.getType());
	}

	@TypeConverter
	public String fromMove(Move value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Move toMove(String json) {
		return gson.fromJson(json, new TypeToken<Move>(){}.getType());
	}

	@TypeConverter
	public String fromMoveList(List<Move> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Move> toMoveList(String json) {
		return gson.fromJson(json, new TypeToken<List<Move>>(){}.getType());
	}

	@TypeConverter
	public String fromContestComboSet(ContestComboSet value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public ContestComboSet toContestComboSet(String json) {
		return gson.fromJson(json, new TypeToken<ContestComboSet>(){}.getType());
	}

	@TypeConverter
	public String fromMoveFlavorTextList(List<MoveFlavorText> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<MoveFlavorText> toMoveFlavorTextList(String json) {
		return gson.fromJson(json, new TypeToken<List<MoveFlavorText>>(){}.getType());
	}

	@TypeConverter
	public String fromMoveMetaData(MoveMetaData value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public MoveMetaData toMoveMetaData(String json) {
		return gson.fromJson(json, new TypeToken<MoveMetaData>(){}.getType());
	}

	@TypeConverter
	public String fromMoveStatChangeList(List<MoveStatChange> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<MoveStatChange> toMoveStatChangeList(String json) {
		return gson.fromJson(json, new TypeToken<List<MoveStatChange>>(){}.getType());
	}

	@TypeConverter
	public String fromPastMoveStatValuesList(List<PastMoveStatValues> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PastMoveStatValues> toPastMoveStatValuesList(String json) {
		return gson.fromJson(json, new TypeToken<List<PastMoveStatValues>>(){}.getType());
	}

	@TypeConverter
	public String fromMoveDamageClass(MoveDamageClass value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public MoveDamageClass toMoveDamageClass(String json) {
		return gson.fromJson(json, new TypeToken<MoveDamageClass>(){}.getType());
	}

	@TypeConverter
	public String fromMoveLearnMethodList(List<MoveLearnMethod> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<MoveLearnMethod> toMoveLearnMethodList(String json) {
		return gson.fromJson(json, new TypeToken<List<MoveLearnMethod>>(){}.getType());
	}

	@TypeConverter
	public String fromMoveTarget(MoveTarget value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public MoveTarget toMoveTarget(String json) {
		return gson.fromJson(json, new TypeToken<MoveTarget>(){}.getType());
	}

	@TypeConverter
	public String fromAbilityList(List<Ability> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Ability> toAbilityList(String json) {
		return gson.fromJson(json, new TypeToken<List<Ability>>(){}.getType());
	}

	@TypeConverter
	public String fromAbilityEffectChangeList(List<AbilityEffectChange> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<AbilityEffectChange> toAbilityEffectChangeList(String json) {
		return gson.fromJson(json, new TypeToken<List<AbilityEffectChange>>(){}.getType());
	}

	@TypeConverter
	public String fromAbilityFlavorTextList(List<AbilityFlavorText> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<AbilityFlavorText> toAbilityFlavorTextList(String json) {
		return gson.fromJson(json, new TypeToken<List<AbilityFlavorText>>(){}.getType());
	}

	@TypeConverter
	public String fromAbilityPokemonList(List<AbilityPokemon> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<AbilityPokemon> toAbilityPokemonList(String json) {
		return gson.fromJson(json, new TypeToken<List<AbilityPokemon>>(){}.getType());
	}

	@TypeConverter
	public String fromCharacteristicList(List<Characteristic> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Characteristic> toCharacteristicList(String json) {
		return gson.fromJson(json, new TypeToken<List<Characteristic>>(){}.getType());
	}

	@TypeConverter
	public String fromEggGroupList(List<EggGroup> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<EggGroup> toEggGroupList(String json) {
		return gson.fromJson(json, new TypeToken<List<EggGroup>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSpeciesGenderList(List<PokemonSpeciesGender> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonSpeciesGender> toPokemonSpeciesGenderList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonSpeciesGender>>(){}.getType());
	}

	@TypeConverter
	public String fromGrowthRate(GrowthRate value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public GrowthRate toGrowthRate(String json) {
		return gson.fromJson(json, new TypeToken<GrowthRate>(){}.getType());
	}

	@TypeConverter
	public String fromGrowthRateExperienceLevelList(List<GrowthRateExperienceLevel> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<GrowthRateExperienceLevel> toGrowthRateExperienceLevelList(String json) {
		return gson.fromJson(json, new TypeToken<List<GrowthRateExperienceLevel>>(){}.getType());
	}

	@TypeConverter
	public String fromNatureStatChangeList(List<NatureStatChange> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<NatureStatChange> toNatureStatChangeList(String json) {
		return gson.fromJson(json, new TypeToken<List<NatureStatChange>>(){}.getType());
	}

	@TypeConverter
	public String fromMoveBattleStylePreferenceList(List<MoveBattleStylePreference> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<MoveBattleStylePreference> toMoveBattleStylePreferenceList(String json) {
		return gson.fromJson(json, new TypeToken<List<MoveBattleStylePreference>>(){}.getType());
	}

	@TypeConverter
	public String fromNaturePokeathlonStatAffectSets(NaturePokeathlonStatAffectSets value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public NaturePokeathlonStatAffectSets toNaturePokeathlonStatAffectSets(String json) {
		return gson.fromJson(json, new TypeToken<NaturePokeathlonStatAffectSets>(){}.getType());
	}

	@TypeConverter
	public String fromPokemon(Pokemon value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Pokemon toPokemon(String json) {
		return gson.fromJson(json, new TypeToken<Pokemon>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonAbilityList(List<PokemonAbility> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonAbility> toPokemonAbilityList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonAbility>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonHeldItemList(List<PokemonHeldItem> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonHeldItem> toPokemonHeldItemList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonHeldItem>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonMoveList(List<PokemonMove> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonMove> toPokemonMoveList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonMove>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSprites(PokemonSprites value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonSprites toPokemonSprites(String json) {
		return gson.fromJson(json, new TypeToken<PokemonSprites>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonStatList(List<PokemonStat> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonStat> toPokemonStatList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonStat>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonTypeList(List<PokemonType> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonType> toPokemonTypeList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonType>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonColor(PokemonColor value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonColor toPokemonColor(String json) {
		return gson.fromJson(json, new TypeToken<PokemonColor>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonFormList(List<PokemonForm> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonForm> toPokemonFormList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonForm>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonFormSprites(PokemonFormSprites value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonFormSprites toPokemonFormSprites(String json) {
		return gson.fromJson(json, new TypeToken<PokemonFormSprites>(){}.getType());
	}

	@TypeConverter
	public String fromAwesomeNameList(List<AwesomeName> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<AwesomeName> toAwesomeNameList(String json) {
		return gson.fromJson(json, new TypeToken<List<AwesomeName>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonHabitat(PokemonHabitat value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonHabitat toPokemonHabitat(String json) {
		return gson.fromJson(json, new TypeToken<PokemonHabitat>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonShape(PokemonShape value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonShape toPokemonShape(String json) {
		return gson.fromJson(json, new TypeToken<PokemonShape>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSpecies(PokemonSpecies value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public PokemonSpecies toPokemonSpecies(String json) {
		return gson.fromJson(json, new TypeToken<PokemonSpecies>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSpeciesList(List<PokemonSpecies> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonSpecies> toPokemonSpeciesList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonSpecies>>(){}.getType());
	}

	@TypeConverter
	public String fromGenusList(List<Genus> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Genus> toGenusList(String json) {
		return gson.fromJson(json, new TypeToken<List<Genus>>(){}.getType());
	}

	@TypeConverter
	public String fromPalParkEncounterAreaList(List<PalParkEncounterArea> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PalParkEncounterArea> toPalParkEncounterAreaList(String json) {
		return gson.fromJson(json, new TypeToken<List<PalParkEncounterArea>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSpeciesDexEntryList(List<PokemonSpeciesDexEntry> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonSpeciesDexEntry> toPokemonSpeciesDexEntryList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonSpeciesDexEntry>>(){}.getType());
	}

	@TypeConverter
	public String fromPokemonSpeciesVarietyList(List<PokemonSpeciesVariety> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<PokemonSpeciesVariety> toPokemonSpeciesVarietyList(String json) {
		return gson.fromJson(json, new TypeToken<List<PokemonSpeciesVariety>>(){}.getType());
	}

	@TypeConverter
	public String fromStat(Stat value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Stat toStat(String json) {
		return gson.fromJson(json, new TypeToken<Stat>(){}.getType());
	}

	@TypeConverter
	public String fromMoveStatAffectSets(MoveStatAffectSets value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public MoveStatAffectSets toMoveStatAffectSets(String json) {
		return gson.fromJson(json, new TypeToken<MoveStatAffectSets>(){}.getType());
	}
	@TypeConverter
	public String fromNatureStatAffectSets(NatureStatAffectSets value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public NatureStatAffectSets toNatureStatAffectSets(String json) {
		return gson.fromJson(json, new TypeToken<NatureStatAffectSets>(){}.getType());
	}

	@TypeConverter
	public String fromType(Type value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public Type toType(String json) {
		return gson.fromJson(json, new TypeToken<Type>(){}.getType());
	}

	@TypeConverter
	public String fromTypeList(List<Type> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Type> toTypeList(String json) {
		return gson.fromJson(json, new TypeToken<List<Type>>(){}.getType());
	}

	@TypeConverter
	public String fromTypePokemonList(List<TypePokemon> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<TypePokemon> toTypePokemonList(String json) {
		return gson.fromJson(json, new TypeToken<List<TypePokemon>>(){}.getType());
	}

	@TypeConverter
	public String fromTypeRelations(TypeRelations value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public TypeRelations toTypeRelations(String json) {
		return gson.fromJson(json, new TypeToken<TypeRelations>(){}.getType());
	}

	@TypeConverter
	public String fromDescriptionList(List<Description> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Description> toDescriptionList(String json) {
		return gson.fromJson(json, new TypeToken<List<Description>>(){}.getType());
	}

	@TypeConverter
	public String fromEffectList(List<Effect> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Effect> toEffectList(String json) {
		return gson.fromJson(json, new TypeToken<List<Effect>>(){}.getType());
	}

	@TypeConverter
	public String fromFlavorTextList(List<FlavorText> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<FlavorText> toFlavorTextList(String json) {
		return gson.fromJson(json, new TypeToken<List<FlavorText>>(){}.getType());
	}

	@TypeConverter
	public String fromGenerationGameIndexList(List<GenerationGameIndex> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<GenerationGameIndex> toGenerationGameIndexList(String json) {
		return gson.fromJson(json, new TypeToken<List<GenerationGameIndex>>(){}.getType());
	}

	@TypeConverter
	public String fromNameList(List<Name> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<Name> toNameList(String json) {
		return gson.fromJson(json, new TypeToken<List<Name>>(){}.getType());
	}

	@TypeConverter
	public String fromVerboseEffectList(List<VerboseEffect> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<VerboseEffect> toVerboseEffectList(String json) {
		return gson.fromJson(json, new TypeToken<List<VerboseEffect>>(){}.getType());
	}

	@TypeConverter
	public String fromVersionGameIndexList(List<VersionGameIndex> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<VersionGameIndex> toVersionGameIndexList(String json) {
		return gson.fromJson(json, new TypeToken<List<VersionGameIndex>>(){}.getType());
	}

	@TypeConverter
	public String fromVersionGroupFlavorTextList(List<VersionGroupFlavorText> value) {
		return gson.toJson(value);
	}

	@TypeConverter
	public List<VersionGroupFlavorText> toVersionGroupFlavorTextList(String json) {
		return gson.fromJson(json, new TypeToken<List<VersionGroupFlavorText>>(){}.getType());
	}

}
