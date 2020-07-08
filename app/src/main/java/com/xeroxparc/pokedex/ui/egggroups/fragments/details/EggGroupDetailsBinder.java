package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.view.View;

import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.FragmentEggGroupDetailsBinding;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupPokemonListAdapter;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EggGroupDetailsBinder implements OnQueryTextListener, EggGroupDetailsLoader {
    private static final String TAG = "EggGroupDetailsBinder";
    private EggGroupDetailsFragment fragment;
    private FragmentEggGroupDetailsBinding binding;
    private EggGroupDetailsViewModel viewModel;
    private EggGroupPokemonListAdapter speciesListAdapter;

    public EggGroupDetailsBinder(EggGroupDetailsFragment detailsFragment, EggGroupType eggGroupType) {
        fragment = detailsFragment;
        binding = FragmentEggGroupDetailsBinding.inflate(detailsFragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(EggGroupDetailsViewModel.class);
        viewModel.setEggGroupId(eggGroupType.getEggGroupApiId());
        initStyling(eggGroupType);
        initList();
    }

    private void initStyling(EggGroupType eggGroupType) {
        binding.eggGroupName.setText(eggGroupType.getEggGroupTextId());
        binding.eggGroupName.setTextColor(fragment.requireContext().
                getColor(eggGroupType.getEggGroupColorId()));
    }

    private void initList() {
        RecyclerView speciesList = binding.eggGroupPokemonList;
        List<PokemonSpecies> species = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment.getContext());
        speciesListAdapter = new EggGroupPokemonListAdapter(fragment.getContext(), this, species);
        speciesList.setLayoutManager(layoutManager);
        speciesList.setAdapter(speciesListAdapter);
    }

    public void bind() {
        viewModel.getEggGroup().observe(fragment, eggGroup -> {
            binding.listLoadingImg.setVisibility(View.GONE);
            if (!eggGroup.isPresent()) {
                Utils.noInternetConnectionWarning(fragment.getContext());
            }
            eggGroup.ifPresent(group -> {
                speciesListAdapter.setSpeciesList(group.getPokemonSpeciesList());
            });
//            eggGroup.ifPresent(group -> {
//                speciesListAdapter.setSpeciesList(group.getPokemonSpeciesList());
//                group.getPokemonSpeciesList().forEach(specie -> {
//                    viewModel.
//                            getSpecie(specie.getId()).
//                            observe(fragment, retrievedSpecie -> retrievedSpecie.
//                                    ifPresent(current -> {
//                                        speciesListAdapter.addSpecie(current);
//                                        current.getVarietyList().forEach(variety -> {
//                                            if (variety.getDefault()) {
//                                                viewModel.
//                                                        getPokemon(variety.getPokemon().getId()).
//                                                        observe(fragment, pokemon -> {
//                                                            pokemon.ifPresent(retrievedPokemon ->
//                                                                    speciesListAdapter.
//                                                                            addImage(retrievedSpecie.get().getName(),
//                                                                                    retrievedPokemon.getSprite().getFrontDefault())
//                                                            );
//                                                        });
//                                            }
//                                        });
//                                    }));
//                });
//            });
        });
    }

    public View getRoot() {
        return binding.getRoot();
    }

    public void onClean() {
        fragment = null;
        binding = null;
        viewModel = null;
    }

    public void loadDetailedSpecieInAdapter(int id, int position) {
        viewModel.getSpecie(id).observe(fragment,
                retrievedSpecie -> retrievedSpecie.ifPresent(current -> {
                    speciesListAdapter.addSpecie(current,position);
                    loadPokemonImageInAdapter(current, position);
                }));
    }

    public void loadPokemonImageInAdapter(PokemonSpecies specie, int position) {
        specie.getVarietyList().forEach(variety -> {
            if (variety.getDefault()) {
                viewModel.
                        getPokemon(variety.getPokemon().getId()).
                        observe(fragment, pokemon -> {
                            pokemon.ifPresent(retrievedPokemon ->
                                    speciesListAdapter.
                                            addImage(specie.getName(),
                                                    retrievedPokemon.getSprite().getFrontDefault(), position)
                            );
                        });
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
