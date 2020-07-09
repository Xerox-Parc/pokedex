package com.xeroxparc.pokedex.ui.egggroups.egggroups.constants;

import com.xeroxparc.pokedex.R;

/*
 * This Enum encapsulates all the relative data of the egg groups as they pretty stable and numerically
 * limited, allowing easy java-side styling and details retrieval
 * @Author CptPackage
 * */
public enum EggGroupType {
    MONSTER(1, R.color.monsterEggGroupColor, R.color.monsterEggGroupColorVariant, R.string.egg_group_monster),
    WATER1(2, R.color.water1EggGroupColor, R.color.water1EggGroupColorVariant, R.string.egg_group_water1),
    BUG(3, R.color.bugEggGroupColor, R.color.bugEggGroupColorVariant, R.string.egg_group_bug),
    FLYING(4, R.color.flyingEggGroupColor, R.color.flyingEggGroupColorVariant, R.string.egg_group_flying),
    FIELD(5, R.color.fieldEggGroupColor, R.color.fieldEggGroupColorVariant, R.string.egg_group_field),
    FAIRY(6, R.color.fairyEggGroupColor, R.color.fairyEggGroupColorVariant, R.string.egg_group_fairy),
    GRASS(7, R.color.grassEggGroupColor, R.color.grassEggGroupColorVariant, R.string.egg_group_grass),
    HUMAN_LIKE(8, R.color.humanLikeEggGroupColor, R.color.humanLikeEggGroupColorVariant, R.string.egg_group_humanlike),
    WATER3(9, R.color.water3EggGroupColor, R.color.water3EggGroupColorVariant, R.string.egg_group_water3),
    MINERAL(10, R.color.mineralEggGroupColor, R.color.mineralEggGroupColorVariant, R.string.egg_group_mineral),
    AMORPHOUS(11, R.color.amorphousEggGroupColor, R.color.amorphousEggGroupColorVariant, R.string.egg_group_amorphous),
    WATER2(12, R.color.water2EggGroupColor, R.color.water2EggGroupColorVariant, R.string.egg_group_water2),
    DITTO(13, R.color.dittoEggGroupColor, R.color.dittoEggGroupColorVariant, R.string.egg_group_ditto),
    DRAGON(14, R.color.dragonEggGroupColor, R.color.dragonEggGroupColorVariant, R.string.egg_group_dragon),
    NO_EGGS(15, R.color.noEggsEggGroupColor, R.color.noEggsEggGroupColorVariant, R.string.egg_group_no_eggs);

    private int eggGroupApiId;
    private int eggGroupColorId;
    private int eggGroupTextId;
    private int eggGroupColorVariantId;

    EggGroupType(int eggGroupId, int eggGroupColorId, int eggGroupColorVariantId, int eggGroupTextId) {
        this.eggGroupApiId = eggGroupId;
        this.eggGroupColorId = eggGroupColorId;
        this.eggGroupTextId = eggGroupTextId;
        this.eggGroupColorVariantId = eggGroupColorVariantId;
    }

    public int getEggGroupApiId() {
        return eggGroupApiId;
    }

    public int getEggGroupColorId() {
        return eggGroupColorId;
    }

    public int getEggGroupTextId() {
        return eggGroupTextId;
    }

    public int getEggGroupColorVariantId() {
        return eggGroupColorVariantId;
    }

    public static EggGroupType getEggGroupTypeById(int id){
        for(EggGroupType type: values()){
            if(type.eggGroupApiId == id){
                return type;
            }
        }
        return null;
    }
}
