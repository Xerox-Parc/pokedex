package com.xeroxparc.pokedex.ui.egggroups.fragments;

import android.widget.Filter;

import static com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;

public interface TypeAndTextFilterable {
    Filter getFilter(FilterMode filterMode);
}
