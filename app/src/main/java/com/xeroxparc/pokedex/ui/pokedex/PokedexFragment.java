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

/**
 *
 *
 * @author Palmieri Ivan
 */
public class PokedexFragment extends CustomActionBarFragment {

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

    public abstract class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> {

        private List<Pokemon> pokemonList = new ArrayList<>();
        private Context ctx;
        public PokemonListAdapter(Context context) {
            ctx = context;
        }

        abstract void onClickCallback(Pokemon pokemon);

        @NonNull
        @Override
        public com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder(new PokemonListItemBinder(parent.getContext(), parent, false));
        }

        @Override
        public int getItemCount() {
            return (pokemonList != null) ? pokemonList.size() : 0;
        }

        @Override
        public void onBindViewHolder(@NonNull com.xeroxparc.pokedex.ui.pokedex.PokedexFragment.PokemonListAdapter.PokemonViewHolder holder, int position) {
            if (pokemonList != null) {


                Pokemon pokemon = pokemonList.get(position);
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
            notifyItemInserted(pokemonList.size());
            //notifyDataSetChanged();
        }

        void setComponentList(List<Pokemon> componentList) {
            this.pokemonList = componentList;
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
                imageView9 = itemView.findViewById(R.id.imageView9);
                cardView = itemView.findViewById(R.id.cardView2);
                pokemonImage = itemView.findViewById(R.id.imageView5);
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
                    this.viewModel.setPrefer(1);
                    binding.switch1.setChecked(true);
                } else {
                    Log.d("Veridica", "Riuscita");
                    this.viewModel.setPrefer(0);
                    binding.switch1.setChecked(false);
                }

            });


        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind() {
            PokedexFragment.PokemonListAdapter componentListAdapter = new PokedexFragment.PokemonListAdapter(fragment.getContext()) {
                @Override
                void onClickCallback(Pokemon pokemon) {
                    showDetail(pokemon);
                }
            };

            binding.recyclerView.setAdapter(componentListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
            binding.recyclerView.setLayoutManager(new GridLayoutManager(fragment.getContext(), 2));
//            viewModel.getListComponent().observe(fragment, componentListAdapter::setComponentList);
            //final int POKEMON_ID_MAX = 807;
            final int POKEMON_ID_MAX = 3;
            for(int i=0; i<POKEMON_ID_MAX; i++) {
                viewModel.getPokemonLiveData(i).observe(fragment, pokemon -> {
                    pokemon.ifPresent(componentListAdapter::addPokemon);

                });
            }
        }

        private void showDetail(@NonNull Pokemon pokemon) {

        }


    }


    public static class PokedexViewModel extends AndroidViewModel {

        static int prefer;
        private PokedexFragment fragment;
        private PokemonRepository repository;
        private MutableLiveData<String> filterPokemonName;


        private LiveData<List<Pokemon>> listPokemon;

        public void setPrefer(int prefer) {

            this.prefer = prefer;
            Log.d("Valore di prefer", String.valueOf(prefer));
        }

        public PokedexViewModel(@NonNull Application application) {
            super(application);
            repository = new PokemonRepository(application);
            filterPokemonName = new MutableLiveData<>("");

//            if(prefer==0){
//
////                listPokemon = Transformations.switchMap(filterPokemonName, name -> name.isEmpty()?
////                        repository.getPokemon(3) :
////                        repository.getPokemon(3));
//
//
//            }
//            else {
//                /*Quando scelgo i pokemon preferiti*/
////                listPokemon = Transformations.switchMap(filterPokemonName, name -> name.isEmpty()?
////                        repository.getComponentListByPrefer() :
////                        repository.getComponentListByPrefer());
//
//            }
        }

        LiveData<List<Pokemon>> getListComponent() {
            return listPokemon;
        }

        void searchPokemon(String name) {

            filterPokemonName.setValue(name);
        }

        LiveData<Optional<Pokemon>> getPokemonLiveData(int id){
            return repository.getPokemon(id);
        }

    }

    class PokemonListItemBinder {

        private final ItemPokemonBinding binding;

        PokemonListItemBinder(Context context, ViewGroup root, Boolean attachToRoot) {
            binding = ItemPokemonBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
        }

        View getRoot() {
            return binding.getRoot();
        }

        void bind(@NonNull Pokemon pokemon, int position) {
            List<PokemonType> typeList = pokemon.getTypeList();
            binding.textView29.setText(typeList.get(0).getType().getName());
            if(typeList.size() > 1){
                binding.textView39.setText(typeList.get(1).getType().getName());
            }
            EggGroupType eggGroupTypeStyling = Utils.eggGroupTypeFromTypeId(typeList.get(0).getType().getId());
            binding.cardView2.setCardBackgroundColor(getContext().getColor(eggGroupTypeStyling.getEggGroupColorId()));

            binding.textViewName.setText(pokemon.getName());
            binding.imageView9.setOnClickListener((v) -> {
                Log.d("PREFER", "Pokemon " + (position + 1) + " aggiunto ai preferiti");
//                pokemon.setPrefer();
            });
        }


    }


}
