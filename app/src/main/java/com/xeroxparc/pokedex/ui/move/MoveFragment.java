package com.xeroxparc.pokedex.ui.move;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.databinding.FragmentMoveBinding;

import java.util.LinkedList;

import static androidx.core.content.ContextCompat.getColor;

public class MoveFragment extends Fragment {

    private FragmentMoveBinding binding;
    final LinkedList<String> movesList = new LinkedList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMoveBinding.inflate(inflater, container, false);
        new Holder(getActivity());
        return binding.getRoot();
    }

    
    class Holder {


        public Holder(FragmentActivity activity) {

            // placeholder mechanism
            for (int i = 0; i < 20; i++) {
                movesList.addLast("Move " + i);
            }

            MoveListAdapter moveListAdapter = new MoveListAdapter(activity, movesList);

            binding.recyclerView.setAdapter(moveListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        }

    }

    private class MoveListAdapter extends RecyclerView.Adapter<MoveListAdapter.ViewHolder> {

        private final LinkedList<String> moveList;
        private LayoutInflater mInflater;

        public MoveListAdapter(Context context, LinkedList<String> moveListDataset){
            mInflater = LayoutInflater.from(context);
            this.moveList = moveListDataset;

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView moveItemView;
            public final MaterialCardView topHalfCard;
            final MoveListAdapter mAdapter;

            public ViewHolder(View itemView, MoveListAdapter adapter) {
                super(itemView);
                moveItemView = itemView.findViewById(R.id.text_view_name);
                topHalfCard = itemView.findViewById(R.id.text_view_card_top_half);
                topHalfCard.setBackgroundColor(getColor(requireContext(), R.color.Blue) );
                this.mAdapter = adapter;
            }

        }

        @NonNull
        @Override
        public MoveListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.move_item,
                    parent, false);
            return new ViewHolder(mItemView, this);
        }

        @Override
        public void onBindViewHolder(@NonNull MoveListAdapter.ViewHolder holder, int position) {

            String currentElement = moveList.get(position);
            holder.moveItemView.setText(currentElement);

            MoveFragmentDirections.ActionNavMoveToNavMoveDetail action = MoveFragmentDirections.actionNavMoveToNavMoveDetail();
            action.setMoveTitle(currentElement);

            holder.itemView.setOnClickListener(item-> {
                Navigation.findNavController(requireView()).navigate(action);
            });

        }

        @Override
        public int getItemCount() {
            return moveList.size();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}