package com.xeroxparc.pokedex.ui.egggroups.components;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.chip.Chip;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;

public class EggGroupChip extends Chip {
    private EggGroupType eggGroupType;

    public EggGroupChip(Context context, EggGroupType eggGroupType, OnClickListener clickListener) {
        super(context);
        setChipBackgroundColorResource(eggGroupType.getEggGroupColorId());
        setText(eggGroupType.getEggGroupTextId());
        this.eggGroupType = eggGroupType;
        setOnClickListener(clickListener);
    }

    public EggGroupChip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}