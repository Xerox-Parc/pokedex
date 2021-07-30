package com.xeroxparc.pokedex.ui.move;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.xeroxparc.pokedex.R;

class MoveViewHolder extends RecyclerView.ViewHolder {

    public final MaterialTextView textViewName;
    public final MaterialTextView textViewType;
    public final ImageView imageViewDamageClass;
    public final MaterialCardView cardViewTopHalf;
    public final MaterialTextView textViewPowerPpAccuracy;

    public final int imageStatus = R.drawable.ic_status;
    public final int imagePhysical = R.drawable.ic_physical;
    public final int imageSpecial = R.drawable.ic_special;

    final MoveListAdapter mAdapter;
    private MoveFragment moveFragment;

    public MoveViewHolder(View itemView, MoveListAdapter adapter, MoveFragment moveFragment) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.text_view_move_list_move_name);
        textViewType = itemView.findViewById(R.id.text_view_type);
        imageViewDamageClass = itemView.findViewById(R.id.image_view_damage_class);
        textViewPowerPpAccuracy = itemView.findViewById(R.id.text_view_power_pp_accuracy);
        cardViewTopHalf = itemView.findViewById(R.id.text_view_card_top_half);
        this.mAdapter = adapter;
        this.moveFragment = moveFragment;
    }

    public void setBackgroundColor(int colorId) {
        cardViewTopHalf.setBackgroundColor(moveFragment.requireContext().getColor(colorId));
    }

}
