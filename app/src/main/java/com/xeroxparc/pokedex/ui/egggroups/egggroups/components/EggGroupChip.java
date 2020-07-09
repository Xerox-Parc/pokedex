package com.xeroxparc.pokedex.ui.egggroups.egggroups.components;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.chip.Chip;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;

public class EggGroupChip extends Chip {
    private EggGroupType eggGroupType;
    public static final String TAG = "EGG_GROUP_CHIP_TAG";

    public EggGroupChip(Context context, EggGroupType eggGroupType, OnClickListener clickListener) {
        super(context);
        setChipBackgroundColorResource(eggGroupType.getEggGroupColorId());
        setText(eggGroupType.getEggGroupTextId());
        setTextColor(context.getColor(R.color.eggGroupButtonTextColor));
        this.eggGroupType = eggGroupType;
        setTag(TAG);
        setOnClickListener(clickListener);
    }

    public EggGroupChip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public EggGroupType getEggGroupType(){
        return eggGroupType;
    }
}