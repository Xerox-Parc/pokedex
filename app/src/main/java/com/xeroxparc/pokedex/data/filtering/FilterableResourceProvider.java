package com.xeroxparc.pokedex.data.filtering;

public interface FilterableResourceProvider<T> {
    String getFilterableResource(T source);
}
