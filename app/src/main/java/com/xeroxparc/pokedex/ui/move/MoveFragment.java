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
import com.xeroxparc.pokedex.data.model.move.MoveFlavorText;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.data.model.utility.common.VerboseEffect;
import com.xeroxparc.pokedex.data.repository.MoveRepository;
import com.xeroxparc.pokedex.databinding.FragmentMoveBinding;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.getColor;

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

        public Holder(FragmentActivity activity) {

            MoveListAdapter moveListAdapter = new MoveListAdapter(activity);
            binding.recyclerView.setAdapter(moveListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            final int MAX_MOVES_NUMBER = 728;
            final MoveRepository moveRepository = new MoveRepository(activity);
            for (int i = 1; i < MAX_MOVES_NUMBER + 1; i++) {
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

            public final MaterialTextView moveItemView;
            public final MaterialTextView moveItemType;
            public final MaterialTextView moveItemViewDamageClass;
            public final MaterialCardView topHalfCard;
            public final MaterialTextView moveItemViewPowerPpAccuracy;
            final MoveListAdapter mAdapter;

            public ViewHolder(View itemView, MoveListAdapter adapter) {
                super(itemView);
                moveItemView = itemView.findViewById(R.id.text_view_name);
                moveItemType = itemView.findViewById(R.id.text_view_type);
                moveItemViewDamageClass = itemView.findViewById(R.id.text_view_damage_class);
                moveItemViewPowerPpAccuracy = itemView.findViewById(R.id.text_view_power_pp_accuracy);
                topHalfCard = itemView.findViewById(R.id.text_view_card_top_half);
                topHalfCard.setBackgroundColor(getColor(requireContext(), R.color.Blue));
                this.mAdapter = adapter;
            }

            public void setBackgroundColor(int colorId) {
                topHalfCard.setBackgroundColor(requireContext().getColor(colorId));
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
            holder.moveItemType.setText(currentElement.getType().getName());
            holder.moveItemViewDamageClass.setText(currentElement.getDamageClass().getName());
            String technical_details = getString(R.string.power_short) + currentElement.getPower() + getString(R.string.pp_short) + currentElement.getPp() + getString(R.string.accuracy_short) + currentElement.getAccuracy();
            holder.moveItemViewPowerPpAccuracy.setText(technical_details);
            holder.setBackgroundColor(Utils.eggGroupTypeFromTypeId(currentElement.getType().getId()).getEggGroupColorId());

            MoveFragmentDirections.ActionNavMoveToNavMoveDetail action = MoveFragmentDirections.actionNavMoveToNavMoveDetail();
            action.setMoveType(currentElement.getType().getName());
            action.setMoveTypeId(currentElement.getType().getId());
            action.setMoveGeneration(currentElement.getGeneration().getName());
            action.setMoveDamageClass(currentElement.getDamageClass().getName());

            if(currentElement.getPower() != null){
                action.setMovePower(currentElement.getPower());
            }
            if(currentElement.getAccuracy() != null){
                action.setMoveAccuracy(currentElement.getAccuracy());
            }
            if(currentElement.getPp() != null){
                action.setMovePp(currentElement.getPp());
            }
            if(currentElement.getPriority() != null){
                action.setMovePriority(currentElement.getPriority());
            }

            List<Name> nameList = currentElement.getNameList();

            for (int i = 0; i < nameList.size(); i++) {
                String languageName = nameList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){
                    holder.moveItemView.setText(nameList.get(i).getName());
                    action.setMoveTitle(nameList.get(i).getName());
                    break;
                }
            }

            List<VerboseEffect> effectList = currentElement.getEffectEntryList();

            String effectChance = String.valueOf(currentElement.getEffectChance());

            for (int i = 0; i < effectList.size(); i++) {
                String languageName = effectList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){

                    String effectText = effectList.get(i).getEffect();

                    if(currentElement.getEffectChance() != null) {
                        effectText = effectText.replace("$effect_chance%", effectChance);
                    }

                    action.setMoveEffectText( effectText);
                    break;
                }
            }

            List<MoveFlavorText> flavorList = currentElement.getFlavorTextEntryList();

            for (int i = 0; i < flavorList.size(); i++) {
                String languageName = flavorList.get(i).getLanguage().getName();
                if(languageName != null && languageName.equalsIgnoreCase(getString(R.string.language))){

                    String flavorText = flavorList.get(i).getFlavorText();
                    flavorText.replace("\n", "");

                    switch(flavorList.get(i).getVersionGroup().getId()){
                        case 0:

                            action.setFlavorRedBlue(flavorText);
                        case 1:
                            action.setFlavorYellow(flavorText);
                        case 2:
                            action.setFlavorGoldSilver(flavorText);
                        case 3:
                            action.setFlavorCrystal(flavorText);
                        case 4:
                            action.setFlavorRubySapphire(flavorText);
                        case 5:
                            action.setFlavorEmerald(flavorText);
                        case 6:
                            action.setFlavorFireredLeafgreen(flavorText);
                        case 7:
                            action.setFlavorDiamondPearl(flavorText);
                        case 8:
                            action.setFlavorPlatinum(flavorText);
                        case 9:
                            action.setFlavorHeartgoldSoulsilver(flavorText);
                        case 10:
                            action.setFlavorBlackWhite(flavorText);
                        case 11:
                            action.setFlavorColosseum(flavorText);
                        case 12:
                            action.setFlavorXd(flavorText);
                        case 13:
                            action.setFlavorBlack2White2(flavorText);
                        case 14:
                            action.setFlavorXY(flavorText);
                        case 15:
                            action.setFlavorOmegarubyAlphasapphire(flavorText);
                        case 16:
                            action.setFlavorSunMoon(flavorText);
                        case 17:
                            action.setFlavorUltrasunUltramoon(flavorText);
                        default:
                    }
                }
            }

            holder.itemView.setOnClickListener(item -> {
                Navigation.findNavController(requireView()).navigate(action);
            });
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