package com.xeroxparc.pokedex.ui.pokedex;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.data.model.pokemon.PokemonType;
import com.xeroxparc.pokedex.data.repository.PokemonRepository;
import com.xeroxparc.pokedex.databinding.FragmentPokedexBinding;
import com.xeroxparc.pokedex.databinding.ItemPokemonBinding;
import com.xeroxparc.pokedex.ui.egggroups.constants.EggGroupType;
import com.xeroxparc.pokedex.ui.parents.CustomActionBarFragment;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokedexFragment extends CustomActionBarFragment {

    private PokedexBinder binder;
    private FragmentPokedexBinding binding;
    private static PokedexFragment.PokemonListAdapter componentListAdapter;

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

    public class CustomActionBarFragment extends AppCompatActivity {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.pokedex_menu, menu);
            return true;
        }
    }

    public abstract class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> implements PokemonUpdateRequester {

        private List<Pokemon> pokemonList = new ArrayList<>();
        private List<Pokemon> filteredList = new ArrayList<>();
        private Context ctx;
        private boolean preferredFiltering = false;
        public PokemonListAdapter(Context context) {
            ctx = context;
        }

        abstract void onClickCallback(Pokemon pokemon);

        @NonNull
        @Override
        public com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder(new PokemonListItemBinder(parent.getContext(), parent, false,this));
        }

        @Override
        public int getItemCount() {
            return filteredList.size();
        }

        @Override
        public void onBindViewHolder(@NonNull com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder holder, int position) {
            if (filteredList != null) {


                Pokemon pokemon = filteredList.get(position);
                String currentElement = pokemon.getName();/*non prende il pokemon corrente*/
                Integer pokemonID = pokemon.getId();

                /*Funzione di trasferimento*/

                PokedexFragmentDirections.ActionNavPokedexToNavPokemonDetail action = PokedexFragmentDirections.actionNavPokedexToNavPokemonDetail();
                action.setDetailsPokemon(currentElement);
                action.setPokemonId(pokemonID);
                holder.cardView.setOnClickListener(v -> {
                    //Bundle pokemonDetails = new Bundle();
                    //pokemonDetails.putInt(PokemonDetailFragment.KEY_POKEMON_ID, pokemon.getId());
                    Navigation.findNavController(requireView()).navigate(action);
                });


                holder.binder.bind(pokemon, position);
                holder.binder.getRoot().setOnClickListener(c -> onClickCallback(pokemon));
                Glide.with(ctx).load(pokemon.getSprite().getFrontDefault()).into(holder.getImageView());
            }
        }


        void addPokemon(Pokemon pokemon) {
            pokemonList.add(pokemon);
            if(preferredFiltering&&pokemon.isFavourite()){
                filteredList.add(pokemon);
            }else{
                filteredList.add(pokemon);
            }
            notifyItemInserted(filteredList.size());
            //notifyDataSetChanged();
        }

        void setFavouriteredFiltering(boolean filtering){
            if(!filtering && preferredFiltering){
                filteredList.clear();
                filteredList.addAll(pokemonList);
            }else if(filtering && !preferredFiltering){
                filteredList = pokemonList.stream().filter(Pokemon::isFavourite).collect(Collectors.toList());
            }
            notifyDataSetChanged();
            preferredFiltering = filtering;
        }

        public boolean isPreferredFiltering() {
            return preferredFiltering;
        }

        public List<Pokemon> getPokemonList(){
            return filteredList;
        }

        void setComponentList(List<Pokemon> componentList) {
            this.pokemonList = componentList;
            filteredList.addAll(pokemonList);
            notifyDataSetChanged();
        }


        public class PokemonViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView9;
            final PokemonListItemBinder binder;
            public FragmentPokedexBinding binding;
            public CardView cardView;
            private ImageView pokemonImage;

            PokemonViewHolder(@NonNull PokemonListItemBinder binder) {
                super(binder.getRoot());
                this.binder = binder;
                imageView9 = itemView.findViewById(R.id.image_view_star);
                cardView = itemView.findViewById(R.id.cardView2);
                pokemonImage = itemView.findViewById(R.id.image_view_pokemon);
            }

            ImageView getImageView(){
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

            binding.switch1.setOnClickListener((v) -> {
                if (binding.switch1.isChecked()) {
                    Log.d("Veridica", "Riuscita");
                    this.viewModel.setFavouriteMode(1);
                    binding.switch1.setChecked(true);
                } else {
                    Log.d("Veridica", "Riuscita");
                    this.viewModel.setFavouriteMode(0);
                    binding.switch1.setChecked(false);
                }

            });


        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind() {
//            PokedexFragment.PokemonListAdapter componentListAdapter = new PokedexFragment.PokemonListAdapter(fragment.getContext()) {
            componentListAdapter = new PokedexFragment.PokemonListAdapter(fragment.getContext()) {
                @Override
                public void requestPokemonUpdate(Pokemon updated,int position) {
                    if(isPreferredFiltering()){
                        if(!updated.isFavourite()){
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
            final int POKEMON_ID_MAX = 807;
            for(int i=0; i<POKEMON_ID_MAX; i++) {
                viewModel.getPokemonLiveData(i).observe(fragment, pokemon -> {
                    pokemon.ifPresent(componentListAdapter::addPokemon);

                });
            }
        }
    }

    public static class PokedexViewModel extends AndroidViewModel {

        static int preferMode;
        private PokedexFragment fragment;
        private PokemonRepository repository;
        private MutableLiveData<String> filterPokemonName;
        private LiveData<List<Pokemon>> listPokemon;

        public void setFavouriteMode(int preferMode) {
            this.preferMode = preferMode;
            componentListAdapter.setFavouriteredFiltering(preferMode == 1 );
            Log.d("Valore di prefer", String.valueOf(preferMode));
        }

        public PokedexViewModel(@NonNull Application application) {
            super(application);
            repository = new PokemonRepository(application);
            filterPokemonName = new MutableLiveData<>("");
        }

        LiveData<List<Pokemon>> getListComponent() {
            return listPokemon;
        }
        void searchPokemon(String name) {
            filterPokemonName.setValue(name);
        }
        LiveData<Optional<Pokemon>> getPokemonLiveData(int id) {
            return repository.getPokemon(id);
        }

        public void updatePokemon(Pokemon updated) {
            repository.updatePokemon(updated);
        }
    }

    class PokemonListItemBinder {

        private final ItemPokemonBinding binding;
        private PokemonUpdateRequester updateRequester;

        PokemonListItemBinder(Context context, ViewGroup root, Boolean attachToRoot, PokemonUpdateRequester updateRequester ) {
            binding = ItemPokemonBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
            this.updateRequester = updateRequester;
        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind(@NonNull Pokemon pokemon, int position) {
            List<PokemonType> typeList = pokemon.getTypeList();
            binding.textViewPokemonType.setText(typeList.get(0).getType().getName());
            if(typeList.size() > 1){
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
            if(!pokemon.isFavourite()) {
                binding.imageViewStar.setImageResource(R.drawable.ic_baseline_star_border_24);
            } else {
                binding.imageViewStar.setImageResource(R.drawable.ic_baseline_star_24);
            }
        }
    }

    interface PokemonUpdateRequester{
        void requestPokemonUpdate(Pokemon updated, int position);
    }

}