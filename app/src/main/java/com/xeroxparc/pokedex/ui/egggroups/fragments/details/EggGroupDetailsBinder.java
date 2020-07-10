package com.xeroxparc.pokedex.ui.egggroups.fragments.details;

import android.view.View;
import android.view.View.OnClickListener;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.species.PokemonSpecies;
import com.xeroxparc.pokedex.databinding.FragmentEggGroupDetailsBinding;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupPokemonListAdapter;
import com.xeroxparc.pokedex.utils.Utils;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.xeroxparc.pokedex.ui.egggroups.lists.adapters.EggGroupSpeciesListFilter.FilterMode;

/*
 * Binds the Fragment with the View-Model, does the filtering data-passing and navigates to the
 * requested details fragment
 *
 * @author Abdelrahman Abdelrahman (CptPackage)
 * */
public class EggGroupDetailsBinder implements
        EggGroupDetailsLoader, EggGroupDetailsNavigationRequester, OnClickListener {
    private static final String TAG = "EggGroupDetailsBinder";
    private final int eggGroupId;
    private EggGroupDetailsFragment fragment;
    private FragmentEggGroupDetailsBinding binding;
    private EggGroupDetailsViewModel viewModel;
    private EggGroupPokemonListAdapter speciesListAdapter;

    public EggGroupDetailsBinder(EggGroupDetailsFragment detailsFragment, EggGroupType eggGroupType) {
        fragment = detailsFragment;
        binding = FragmentEggGroupDetailsBinding.inflate(detailsFragment.getLayoutInflater());
        viewModel = new ViewModelProvider(fragment).get(EggGroupDetailsViewModel.class);
        eggGroupId = eggGroupType.getEggGroupApiId();
        binding.showAllPokemon.setOnClickListener(this);
        binding.showPokemonOnlyInThisGroup.setOnClickListener(this);
        binding.showPokemonInThisGroupAndOthers.setOnClickListener(this);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment.getContext());
        speciesListAdapter = new EggGroupPokemonListAdapter(fragment.getContext(), this,
                viewModel.getRawSpeciesList(), viewModel.getDetailedSpeciesMap(),
                viewModel.getPokemonMap(), viewModel.getLoadingMap(), this);
        speciesList.setLayoutManager(layoutManager);
        speciesList.setAdapter(speciesListAdapter);
    }

    public void bind() {
        viewModel.setEggGroupId(eggGroupId);
        viewModel.getEggGroup().observe(fragment, eggGroup -> {
            binding.listLoadingImg.setVisibility(View.GONE);
            if (!eggGroup.isPresent()) {
                Utils.noInternetConnectionWarning(fragment.getContext());
            }
            eggGroup.ifPresent(group -> {
                viewModel.getRawSpeciesList().clear();
                viewModel.getRawSpeciesList().addAll(group.getPokemonSpeciesList());
                speciesListAdapter.setSimpleSpeciesList(viewModel.getRawSpeciesList());
            });
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
                    speciesListAdapter.addSpecie(current, position);
                    loadPokemonImageInAdapter(current, position);
                }));
    }

    public void loadPokemonImageInAdapter(PokemonSpecies specie, int position) {
        specie.getVarietyList().forEach(variety -> {
            if (variety.getDefault()) {
                viewModel.
                        getPokemon(variety.getPokemon().getId()).
                        observe(fragment, pokemon -> pokemon.ifPresent(retrievedPokemon ->
                                speciesListAdapter.
                                        addImage(specie.getName(),
                                                retrievedPokemon, position)
                        ));
            }
        });
    }


    public EggGroupPokemonListAdapter getSpeciesListAdapter() {
        return speciesListAdapter;
    }

    @Override
    public void navigateToEggGroup(EggGroupType type) {
        if (eggGroupId != type.getEggGroupApiId()) {
            EggGroupDetailsFragmentDirections.ActionNavEggDetailToDiffNavEggDetail action = EggGroupDetailsFragmentDirections.actionNavEggDetailToDiffNavEggDetail();
            action.setEggGroupTypeId(type.getEggGroupApiId());
            Navigation.findNavController(fragment.requireView()).
                    navigate(action);
        }
    }

    @Override
    public void navigateToPokemon(int pokemonId) {
        EggGroupDetailsFragmentDirections.ActionNavEggDetailsToNavPokemonDetail action = EggGroupDetailsFragmentDirections.actionNavEggDetailsToNavPokemonDetail();
        action.setPokemonId(pokemonId);
        Navigation.findNavController(fragment.requireView()).
                navigate(action);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_all_pokemon:
                speciesListAdapter.getFilter(FilterMode.MODE_ALL).filter("");
                break;
            case R.id.show_pokemon_only_in_this_group:
                speciesListAdapter.getFilter(FilterMode.MODE_ONLY_UNIQUE_EGG_GROUP).filter("");
                break;
            case R.id.show_pokemon_in_this_group_and_others:
                speciesListAdapter.getFilter(FilterMode.MODE_UNIQUE_AND_OTHER_EGG_GROUPS).filter("");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}
