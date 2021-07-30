package com.xeroxparc.pokedex.ui.pokedex.detail.moves;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.pokemon.Pokemon;
import com.xeroxparc.pokedex.databinding.FragmentPokemonMovesBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Palmieri Ivan
 */
public abstract class PokemonMovesListAdapter extends RecyclerView.Adapter<PokemonMovesListAdapter.PokemonMovesViewHolder> {

    private List<Move> movesList;

    public PokemonMovesListAdapter() {
        this.movesList = new ArrayList<>();
    }

    abstract void onClickCallback(Move move);

    @NonNull
    @Override
    public PokemonMovesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonMovesViewHolder(new PokemonMovesListItemBinder(parent.getContext(), parent, false));
    }

    @Override
    public int getItemCount() {
        return movesList.size();
    }


    @Override
    public void onBindViewHolder(@NonNull PokemonMovesViewHolder holder, int position) {
        if (movesList != null) {
            Move move = movesList.get(position);
            holder.binder.bind();
            holder.binder.getRoot().setOnClickListener(c -> onClickCallback(move));
            holder.setMoveName(move.getName());
        }
    }

    void setMoves(List<Move> moves) {
        movesList = moves;
        notifyDataSetChanged();
    }

    static class PokemonMovesViewHolder extends RecyclerView.ViewHolder {
        final PokemonMovesListItemBinder binder;
        private TextView moveName;
        PokemonMovesViewHolder(@NonNull PokemonMovesListItemBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
           // moveName = binde
            moveName = binder.getRoot().findViewById(R.id.text_view_pokemon_move_name);
        }

        public void setMoveName(String moveName) {
            this.moveName.setText(moveName);
        }
    }
}
