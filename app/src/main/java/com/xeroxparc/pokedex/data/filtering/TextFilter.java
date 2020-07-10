package com.xeroxparc.pokedex.data.filtering;

import android.widget.Filter;

import com.xeroxparc.pokedex.data.model.utility.common.NamedApiResource;

import java.util.ArrayList;
import java.util.List;

public class TextFilter<T extends NamedApiResource> extends Filter {
    private final List<T> sourceList;
    private final PostFilteringCallBack<List<T>> callback;
    private FilterableResourceProvider<T> filterableResourceProvider;
    private String filteringKeyword = "";

    public TextFilter(List<T> sourceList, PostFilteringCallBack<List<T>> callback,
                      FilterableResourceProvider<T> filterableResourceProvider) {
        this.sourceList = sourceList;
        this.callback = callback;
        this.filterableResourceProvider = filterableResourceProvider;
    }

    @Override
    protected FilterResults performFiltering(CharSequence filterKeyword) {
        List<T> filteredList = new ArrayList<>();
        String formattedKeyword = String.valueOf(filterKeyword).trim().toLowerCase();
        filteringKeyword = formattedKeyword;
        if (filterKeyword != null && !formattedKeyword.isEmpty()) {
            sourceList.
                    stream()
                    .filter(item ->
                            filterableResourceProvider.getFilterableResource(item).
                                    toLowerCase().
                                    trim().
                                    contains(formattedKeyword)).
                    forEach(filteredList::add);
        } else {
            filteredList.addAll(sourceList);
        }
        FilterResults results = new FilterResults();
        results.values = filteredList;
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence filterKeyword, FilterResults filterResults) {
        Object results = filterResults.values;
        if (results instanceof List) {
            List<T> finalList = (List<T>) results;
            callback.postFiltering(finalList);
        }
    }

    public void filterByLastKeyword(){
        if(filteringKeyword != null && filteringKeyword.length() > 0){
            filter(filteringKeyword);
        }
    }

    public String getFilteringKeyword() {
        return filteringKeyword;
    }
}
