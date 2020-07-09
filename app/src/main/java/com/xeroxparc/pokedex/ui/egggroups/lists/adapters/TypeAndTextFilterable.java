package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.widget.Filter;

import static com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;

public interface TypeAndTextFilterable {
    Filter getFilter(FilterMode filterMode);
}
