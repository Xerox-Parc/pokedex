package com.xeroxparc.pokedex.data.filtering;

import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.List;

public interface TextFilterable<T extends NamedApiResource> extends PostFilteringCallBack<List<T>> {
    TextFilter<T> getFilter();
}
