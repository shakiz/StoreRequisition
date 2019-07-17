package com.example.storerequisition.Adapter;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.storerequisition.Model.ItemModel;
import com.example.storerequisition.R;
import com.example.storerequisition.Utils.RecyclerViewTouchListener;
import java.util.ArrayList;

public class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.ViewHolder>{
    private ArrayList<ItemModel> ItemModels;
    private Context context;
    private RecyclerView recyclerView;
    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout bottomSheetLayout;
    private int lastPosition = -1;

    public RecyclerViewItemAdapter(ArrayList<ItemModel> itemModels, Context context, RecyclerView recyclerView, BottomSheetBehavior bottomSheetBehavior,LinearLayout bottomSheetLayout) {
        ItemModels = itemModels;
        this.context = context;
        this.recyclerView = recyclerView;
        this.bottomSheetBehavior = bottomSheetBehavior;
        this.bottomSheetLayout = bottomSheetLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_store,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemModel itemModel = ItemModels.get(position);
        holder.ItemName.setText(itemModel.getItemName());
        holder.ItemIcon.setImageResource(itemModel.getItemIcon());
        //holder.itemView.getLayoutParams().width = /
        setAnimation(holder.itemView, position);
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(context, recyclerView, new RecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                bottomSheetLayout.setVisibility(View.VISIBLE);
                toggleBottomSheet();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return ItemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ItemName;
        ImageView ItemIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.ItemName);
            ItemIcon = itemView.findViewById(R.id.ItemIcon);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_up_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public void toggleBottomSheet() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}
