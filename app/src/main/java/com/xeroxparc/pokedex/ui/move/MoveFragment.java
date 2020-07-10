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

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.repository.MoveRepository;
import com.xeroxparc.pokedex.databinding.FragmentMoveBinding;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class MoveFragment extends Fragment {

    private FragmentMoveBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMoveBinding.inflate(inflater, container, false);
        new Holder(getActivity());
        return binding.getRoot();
    }


    class Holder {

        static final int MAX_MOVES_ID = 728;

        public Holder(FragmentActivity activity) {

            MoveListAdapter moveListAdapter = new MoveListAdapter(activity);
            binding.recyclerView.setAdapter(moveListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

            // Request to take Moves from either the database or the web
            final MoveRepository moveRepository = new MoveRepository(activity);
            for (int i = 1; i < MAX_MOVES_ID + 1; i++) {
                moveRepository.getMove(i).observe(activity, move ->
                        move.ifPresent(moveListAdapter::addMove)
                );
            }
        }

    }

    private class MoveListAdapter extends RecyclerView.Adapter<MoveListAdapter.ViewHolder> {

        private final List<Move> moveList;
        private LayoutInflater mInflater;

        public MoveListAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
            moveList = new ArrayList<>();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public final MaterialTextView textViewName;
            public final MaterialTextView textViewType;
            public final MaterialTextView textViewDamageClass;
            public final MaterialCardView cardViewTopHalf;
            public final MaterialTextView textViewPowerPpAccuracy;
            final MoveListAdapter mAdapter;

            public ViewHolder(View itemView, MoveListAdapter adapter) {
                super(itemView);
                textViewName = itemView.findViewById(R.id.text_view_move_list_move_name);
                textViewType = itemView.findViewById(R.id.text_view_type);
                textViewDamageClass = itemView.findViewById(R.id.text_view_damage_class);
                textViewPowerPpAccuracy = itemView.findViewById(R.id.text_view_power_pp_accuracy);
                cardViewTopHalf = itemView.findViewById(R.id.text_view_card_top_half);
                this.mAdapter = adapter;
            }

            public void setBackgroundColor(int colorId) {
                cardViewTopHalf.setBackgroundColor(requireContext().getColor(colorId));
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

            Move currentElement = moveList.get(position);
            holder.textViewType.setText(currentElement.getType().getName());
            holder.textViewDamageClass.setText(currentElement.getDamageClass().getName());
            String technicalDetails = getString(R.string.power_short) + currentElement.getPower() + getString(R.string.pp_short) + currentElement.getPp() + getString(R.string.accuracy_short) + currentElement.getAccuracy();
            holder.textViewPowerPpAccuracy.setText(technicalDetails);
            holder.setBackgroundColor(Utils.eggGroupTypeFromTypeId(currentElement.getType().getId()).getEggGroupColorId());

            // navigation logic to go to the move_detail layout
            MoveFragmentDirections.ActionNavMoveToNavMoveDetail action = MoveFragmentDirections.actionNavMoveToNavMoveDetail();
            action.setMoveId(currentElement.getId());

            // set the name of the move as the one in the preferred language from the getNameList() API
            List<Name> nameList = currentElement.getNameList();

            for (int i = 0; i < nameList.size(); i++) {
                String languageName = nameList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){
                    holder.textViewName.setText(nameList.get(i).getText());
                    break;
                }
            }


            holder.itemView.setOnClickListener(item ->
                Navigation.findNavController(requireView()).navigate(action)
            );
        }

        public void addMove(Move move) {
            moveList.add(move);
            notifyItemInserted(moveList.size());
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