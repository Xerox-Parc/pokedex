package com.xeroxparc.pokedex.ui.egggroups.lists.adapters;
/*
*  This interface is the callback for the after egg group filtering
*
* @author Abdelrahman Abdelrahman (CptPackage)
* */
public interface PostFilteringCallBack<T> {
    void postFiltering(T filteredData);
}
