package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;

import android.widget.Filter;

import static com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;
/*
 * This filterable-like interface is used to filter the egg groups by egg group type
 * and by name
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public interface TypeAndTextFilterable {
    Filter getFilter(FilterMode filterMode);
}
