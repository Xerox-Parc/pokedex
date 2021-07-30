package com.xeroxparc.pokedex.data.filtering;
/*
*  This interface is the callback for the after egg group filtering
*
* @author Abdelrahman Abdelrahman (CptPackage)
* */
public interface PostFilteringCallBack<T> {
    void postFiltering(T filteredData);
}
