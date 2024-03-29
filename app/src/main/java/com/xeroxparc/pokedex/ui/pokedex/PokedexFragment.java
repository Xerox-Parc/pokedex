package com.xeroxparc.pokedex.ui.pokedex;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.filtering.FilterableResourceProvider;
import com.xeroxparc.pokedex.data.filtering.TextFilter;
import com.xeroxparc.pokedex.data.filtering.TextFilterable;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.databinding.FragmentPokedexBinding;
import com.xeroxparc.pokedex.databinding.ItemPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.parents.SearchableFragment;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Palmieri Ivan
 */
public class PokedexFragment extends SearchableFragment {
    private static final String TAG = "PokedexFragment";
    private static PokedexFragment.PokemonListAdapter componentListAdapter;
    private PokedexBinder binder;
    private FragmentPokedexBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = new PokedexBinder(this);
        binder.bind();
        return binder.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder = null;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        onQueryTextChange(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (binder != null && componentListAdapter != null) {
            componentListAdapter.getFilter().filter(newText);
        }
        return false;
    }

    interface PokemonUpdateRequester {
        void requestPokemonUpdate(Pokemon updated, int position);
    }

    public static class PokedexViewModel extends AndroidViewModel {

        static int preferMode;
        private PokedexFragment fragment;
        private PokemonRepository repository;
        private MutableLiveData<String> filterPokemonName;

        public PokedexViewModel(@NonNull Application application) {
            super(application);
            repository = new PokemonRepository(application);
            filterPokemonName = new MutableLiveData<>("");
        }

        public void setFavouriteMode(int preferMode) {
            this.preferMode = preferMode;
            componentListAdapter.setFavouriteredFiltering(preferMode == 1);
            Log.d("Valore di prefer", String.valueOf(preferMode));
        }

        LiveData<Optional<Pokemon>> getPokemonLiveData(int id) {
            return repository.getPokemon(id);
        }

        public void updatePokemon(Pokemon updated) {
            repository.updatePokemon(updated);
        }
    }

    public abstract class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>
            implements PokemonUpdateRequester, TextFilterable<Pokemon>, FilterableResourceProvider<Pokemon> {
        private List<Pokemon> pokemonList = new ArrayList<>();
        private List<Pokemon> preferredList = new ArrayList<>();
        private List<Pokemon> filteredList = new ArrayList<>();
        private boolean preferredFiltering = false;
        private TextFilter<Pokemon> currentFilter;

        abstract void onClickCallback(Pokemon pokemon);

        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokemonViewHolder(new PokemonListItemBinder(parent.getContext(), parent, false, this));
        }

        @Override
        public int getItemCount() {
            return filteredList.size();
        }

        @Override
        public void onBindViewHolder(@NonNull PokemonListAdapter.PokemonViewHolder holder, int position) {
            if (filteredList != null) {
                Pokemon pokemon = filteredList.get(position);
                String currentElement = pokemon.getName();/*non prende il pokemon corrente*/
                Integer pokemonID = pokemon.getId();

                /*Funzione di trasferimento*/

                PokedexFragmentDirections.ActionNavPokedexToNavPokemonDetail action = PokedexFragmentDirections.actionNavPokedexToNavPokemonDetail();
                action.setDetailsPokemon(currentElement);
                action.setPokemonId(pokemonID);
                holder.cardView.setOnClickListener(v ->
                    Navigation.findNavController(requireView()).navigate(action)
                );


                holder.binder.bind(pokemon, position);
                holder.binder.getRoot().setOnClickListener(c -> onClickCallback(pokemon));
                Glide.with(requireContext()).load(pokemon.getSprite().getFrontDefault()).into(holder.getImageView());
            }
        }

        public List<Pokemon> getPreferredList() {
            return preferredList;
        }

        public List<Pokemon> getFilteredList() {
            return filteredList;
        }

        void addPokemon(Pokemon pokemon) {
            if (preferredFiltering) {
                if (pokemon.isFavourite()) {
                    preferredList.add(pokemon);
                    checkFilteringAndPerform(pokemon);
                }
            } else {
                preferredList.add(pokemon);
                checkFilteringAndPerform(pokemon);
            }
            pokemonList.add(pokemon);
            notifyDataSetChanged();
        }

        void checkFilteringAndPerform(Pokemon pokemon) {
            if (currentFilter == null || currentFilter.getFilteringKeyword().isEmpty()) {
                filteredList.add(pokemon);
            } else {
                currentFilter.filterByLastKeyword();
            }
        }

        void setFavouriteredFiltering(boolean filtering) {
            filteredList.clear();
            preferredList.clear();
            if (!filtering) {
                preferredList.addAll(pokemonList);
            } else {
                preferredList.addAll(pokemonList.stream().filter(Pokemon::isFavourite).collect(Collectors.toList()));
            }
            preferredList.forEach(this::checkFilteringAndPerform);
            preferredFiltering = filtering;
            notifyDataSetChanged();
        }

        public boolean isPreferredFiltering() {
            return preferredFiltering;
        }

        public List<Pokemon> getPokemonList() {
            return preferredList;
        }

        public void setCurrentFilter(TextFilter<Pokemon> currentFilter) {
            this.currentFilter = currentFilter;
        }

        public class PokemonViewHolder extends RecyclerView.ViewHolder {
            final PokemonListItemBinder binder;
            public ImageView imageView9;
            public FragmentPokedexBinding binding;
            public CardView cardView;
            private ImageView pokemonImage;

            PokemonViewHolder(@NonNull PokemonListItemBinder binder) {
                super(binder.getRoot());
                this.binder = binder;
                ;
                cardView = itemView.findViewById(R.id.cardView2);
                pokemonImage = itemView.findViewById(R.id.image_view_pokemon);
            }

            ImageView getImageView() {
                return pokemonImage;
            }
        }
    }

    public class PokedexBinder {
        private final FragmentPokedexBinding binding;
        private final PokedexFragment fragment;
        private PokedexViewModel viewModel;


        PokedexBinder(@NonNull PokedexFragment fragment) {
            this.fragment = fragment;
            binding = FragmentPokedexBinding.inflate(fragment.getLayoutInflater());
            viewModel = new ViewModelProvider(fragment).get(PokedexViewModel.class);

            binding.switchPrefer.setOnClickListener((v) -> {
                if (binding.switchPrefer.isChecked()) {
                    Log.d("Veridica", "Riuscita");
                    this.viewModel.setFavouriteMode(1);
                    binding.switchPrefer.setChecked(true);
                } else {
                    Log.d("Veridica", "Riuscita");
                    this.viewModel.setFavouriteMode(0);
                    binding.switchPrefer.setChecked(false);
                }

            });


        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind() {
            componentListAdapter = new PokedexFragment.PokemonListAdapter() {
                @Override
                public String getFilterableResource(Pokemon source) {
                    return source.getName();
                }

                @Override
                public void postFiltering(List<Pokemon> filteredData) {
                    getFilteredList().clear();
                    getFilteredList().addAll(filteredData);
                    notifyDataSetChanged();
                }

                @Override
                public TextFilter<Pokemon> getFilter() {
                    TextFilter<Pokemon> filter = new TextFilter<>(getPreferredList(), this, this);
                    setCurrentFilter(filter);
                    return filter;
                }

                @Override
                public void requestPokemonUpdate(Pokemon updated, int position) {
                    if (isPreferredFiltering()) {
                        if (!updated.isFavourite()) {
                            getPokemonList().remove(position);
                        }
                    }
                    viewModel.updatePokemon(updated);
                    notifyDataSetChanged();
                }

                @Override
                void onClickCallback(Pokemon pokemon) {

                }
            };

            binding.recyclerView.setAdapter(componentListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
            binding.recyclerView.setLayoutManager(new GridLayoutManager(fragment.getContext(), 2));
            final int POKEMON_ID_MAX = 151;
            for (int i = 0; i <= POKEMON_ID_MAX; i++) {
                viewModel.getPokemonLiveData(i).observe(fragment, pokemon -> {
                    pokemon.ifPresent(componentListAdapter::addPokemon);

                });
            }
        }
    }

    class PokemonListItemBinder {

        private final ItemPokemonBinding binding;
        private PokemonUpdateRequester updateRequester;

        PokemonListItemBinder(Context context, ViewGroup root, Boolean attachToRoot, PokemonUpdateRequester updateRequester) {
            binding = ItemPokemonBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
            this.updateRequester = updateRequester;
        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind(@NonNull Pokemon pokemon, int position) {
            List<PokemonType> typeList = pokemon.getTypeList();
            binding.textViewPokemonType.setText(typeList.get(0).getType().getName());
            if (typeList.size() > 1) {
                binding.textViewPokemonType2.setText(typeList.get(1).getType().getName());
            }
            EggGroupType eggGroupTypeStyling = Utils.eggGroupTypeFromTypeId(typeList.get(0).getType().getId());
            binding.cardView2.setCardBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));
            updateFavoriteView(pokemon);

            binding.textViewPokemonName.setText(pokemon.getName());
            binding.imageViewStar.setOnClickListener(v -> {
                pokemon.setFavourite(!pokemon.isFavourite());
                updateFavoriteView(pokemon);
                updateRequester.requestPokemonUpdate(pokemon, position);
            });
        }

        void updateFavoriteView(@NonNull Pokemon pokemon) {
            if (!pokemon.isFavourite()) {
                binding.imageViewStar.setImageResource(R.drawable.ic_baseline_star_border_24);
            } else {
                binding.imageViewStar.setImageResource(R.drawable.ic_baseline_star_24);
            }
        }
    }

}