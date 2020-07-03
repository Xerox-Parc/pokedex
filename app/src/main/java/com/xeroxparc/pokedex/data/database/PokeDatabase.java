package com.xeroxparc.pokedex.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.xeroxparc.pokedex.data.database.dao.berry.BerryDao;
import com.xeroxparc.pokedex.data.database.dao.berry.BerryFirmnessDao;
import com.xeroxparc.pokedex.data.database.dao.berry.BerryFlavorDao;
import com.xeroxparc.pokedex.data.database.dao.contest.ContestEffectDao;
import com.xeroxparc.pokedex.data.database.dao.contest.ContestTypeDao;
import com.xeroxparc.pokedex.data.database.dao.contest.SuperContestEffectDao;
import com.xeroxparc.pokedex.data.database.dao.encounter.EncounterConditionDao;
import com.xeroxparc.pokedex.data.database.dao.encounter.EncounterConditionValueDao;
import com.xeroxparc.pokedex.data.database.dao.encounter.EncounterMethodDao;
import com.xeroxparc.pokedex.data.database.dao.evolution.EvolutionChainDao;
import com.xeroxparc.pokedex.data.database.dao.evolution.EvolutionTriggerDao;
import com.xeroxparc.pokedex.data.database.dao.game.GenerationDao;
import com.xeroxparc.pokedex.data.database.dao.game.PokedexDao;
import com.xeroxparc.pokedex.data.database.dao.game.VersionDao;
import com.xeroxparc.pokedex.data.database.dao.game.VersionGroupDao;
import com.xeroxparc.pokedex.data.database.dao.item.ItemAttributeDao;
import com.xeroxparc.pokedex.data.database.dao.item.ItemCategoryDao;
import com.xeroxparc.pokedex.data.database.dao.item.ItemDao;
import com.xeroxparc.pokedex.data.database.dao.item.ItemFlingEffectDao;
import com.xeroxparc.pokedex.data.database.dao.item.ItemPocketDao;
import com.xeroxparc.pokedex.data.database.dao.location.LocationAreaDao;
import com.xeroxparc.pokedex.data.database.dao.location.LocationDao;
import com.xeroxparc.pokedex.data.database.dao.location.PalParkAreaDao;
import com.xeroxparc.pokedex.data.database.dao.location.RegionDao;
import com.xeroxparc.pokedex.data.database.dao.machine.MachineDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveAilmentDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveBattleStyleDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveCategoryDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveDamageClassDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveLearnMethodDao;
import com.xeroxparc.pokedex.data.database.dao.move.MoveTargetDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.AbilityDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.CharacteristicDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.EggGroupDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.GenderDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.GrowthRateDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.NatureDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokeathlonStatDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonColorDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonFormDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonHabitatDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonShapeDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.PokemonSpeciesDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.StatDao;
import com.xeroxparc.pokedex.data.database.dao.pokemon.TypeDao;
import com.xeroxparc.pokedex.data.database.dao.utility.LanguageDao;
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

/**
 * @author Fabio Buracchi
 */
@Database(
		entities = {
				Berry.class,
				BerryFirmness.class,
				BerryFlavor.class,
				ContestType.class,
				ContestEffect.class,
				SuperContestEffect.class,
				EncounterMethod.class,
				EncounterCondition.class,
				EncounterConditionValue.class,
				EvolutionChain.class,
				EvolutionTrigger.class,
				Generation.class,
				Pokedex.class,
				Version.class,
				VersionGroup.class,
				Item.class,
				ItemAttribute.class,
				ItemCategory.class,
				ItemFlingEffect.class,
				ItemPocket.class,
				Location.class,
				LocationArea.class,
				PalParkArea.class,
				Region.class,
				Machine.class,
				Move.class,
				MoveAilment.class,
				MoveBattleStyle.class,
				MoveCategory.class,
				MoveDamageClass.class,
				MoveLearnMethod.class,
				MoveTarget.class,
				Ability.class,
				Characteristic.class,
				EggGroup.class,
				Gender.class,
				GrowthRate.class,
				Nature.class,
				PokeathlonStat.class,
				Pokemon.class,
				PokemonColor.class,
				PokemonForm.class,
				PokemonHabitat.class,
				PokemonShape.class,
				PokemonSpecies.class,
				Stat.class,
				Type.class,
				Language.class
		},
		version = 1,
		exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class PokeDatabase extends RoomDatabase {

	private static PokeDatabase instance;

	public static synchronized PokeDatabase getDatabase(final Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(
					context.getApplicationContext(),
					PokeDatabase.class,
					"PokeDatabase")
					.build();
		}
		return instance;
	}

	public abstract BerryDao berryDao();
	public abstract BerryFirmnessDao berryFirmnessDao();
	public abstract BerryFlavorDao berryFlavorDao();
	public abstract ContestTypeDao contestTypeDao();
	public abstract ContestEffectDao contestEffectDao();
	public abstract SuperContestEffectDao superContestEffectDao();
	public abstract EncounterMethodDao encounterMethodDao();
	public abstract EncounterConditionDao encounterConditionDao();
	public abstract EncounterConditionValueDao encounterConditionValueDao();
	public abstract EvolutionChainDao evolutionChainDao();
	public abstract EvolutionTriggerDao evolutionTriggerDao();
	public abstract GenerationDao generationDao();
	public abstract PokedexDao pokedexDao();
	public abstract VersionDao versionDao();
	public abstract VersionGroupDao versionGroupDao();
	public abstract ItemDao itemDao();
	public abstract ItemAttributeDao itemAttributeDao();
	public abstract ItemCategoryDao itemCategoryDao();
	public abstract ItemFlingEffectDao itemFlingEffectDao();
	public abstract ItemPocketDao itemPocketDao();
	public abstract LocationDao locationDao();
	public abstract LocationAreaDao locationAreaDao();
	public abstract PalParkAreaDao palParkAreaDao();
	public abstract RegionDao regionDao();
	public abstract MachineDao machineDao();
	public abstract MoveDao moveDao();
	public abstract MoveAilmentDao moveAilmentDao();
	public abstract MoveBattleStyleDao moveBattleStyleDao();
	public abstract MoveCategoryDao moveCategoryDao();
	public abstract MoveDamageClassDao moveDamageClassDao();
	public abstract MoveLearnMethodDao moveLearnMethodDao();
	public abstract MoveTargetDao moveTargetDao();
	public abstract AbilityDao abilityDao();
	public abstract CharacteristicDao characteristicDao();
	public abstract EggGroupDao eggGroupDao();
	public abstract GenderDao genderDao();
	public abstract GrowthRateDao growthRateDao();
	public abstract NatureDao natureDao();
	public abstract PokeathlonStatDao pokeathlonStatDao();
	public abstract PokemonDao pokemonDao();
	public abstract PokemonColorDao pokemonColorDao();
	public abstract PokemonFormDao pokemonFormDao();
	public abstract PokemonHabitatDao pokemonHabitatDao();
	public abstract PokemonShapeDao pokemonShapeDao();
	public abstract PokemonSpeciesDao pokemonSpeciesDao();
	public abstract StatDao statDao();
	public abstract TypeDao typeDao();
	public abstract LanguageDao languageDao();
}
