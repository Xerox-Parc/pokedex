package com.xeroxparc.pokedex.ui.move;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.pokedex.R;
import com.xeroxparc.pokedex.data.model.move.Move;
import com.xeroxparc.pokedex.data.model.utility.common.Name;
import com.xeroxparc.pokedex.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MoveListAdapter extends RecyclerView.Adapter<MoveViewHolder> {

    private final List<Move> moveList;
    private LayoutInflater mInflater;
    private MoveFragment fragment;

    public MoveListAdapter(MoveFragment moveFragment, Context context) {
        mInflater = LayoutInflater.from(context);
        moveList = new ArrayList<>();
        this.fragment = moveFragment;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.move_item,
                parent, false);
        return new MoveViewHolder(mItemView, this, fragment);
    }



    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {

        Move currentElement = moveList.get(position);
        holder.textViewType.setText(currentElement.getType().getName());

        holder.imageViewDamageClass.setImageResource(selectDamageClass(currentElement.getDamageClass().getName(), holder));

        String technical_details = fragment.getString(R.string.power_short) + currentElement.getPower() + fragment.getString(R.string.pp_short) + currentElement.getPp() + fragment.getString(R.string.accuracy_short) + currentElement.getAccuracy();
        holder.textViewPowerPpAccuracy.setText(technical_details);
        holder.setBackgroundColor(Utils.eggGroupTypeFromTypeId(currentElement.getType().getId()).getEggGroupColorId());

        // navigation logic to go to the move_detail layout
        MoveFragmentDirections.ActionNavMoveToNavMoveDetail action = MoveFragmentDirections.actionNavMoveToNavMoveDetail();
        action.setMoveId(currentElement.getId());

        // set the name of the move as the one in the preferred language from the getNameList() API
        List<Name> nameList = currentElement.getNameList();

        for (int i = 0; i < nameList.size(); i++) {
            String languageName = nameList.get(i).getLanguage().getName();
            if(languageName != null && languageName.equalsIgnoreCase(fragment.getString(R.string.language))){
                holder.textViewName.setText(nameList.get(i).getText());
                break;
            }
        }


        holder.itemView.setOnClickListener(item -> {
            Navigation.findNavController(fragment.requireView()).navigate(action);
        });
    }

    private int selectDamageClass(String name, MoveViewHolder holder) {
        switch(name) {
            case "status":
                return holder.imageStatus;
            case "physical":
                return holder.imagePhysical;
            default:
                return holder.imageSpecial;
        }
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
