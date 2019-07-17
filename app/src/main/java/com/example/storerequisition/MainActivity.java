package com.example.storerequisition;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.storerequisition.Adapter.RecyclerViewItemAdapter;
import com.example.storerequisition.Model.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemModel> ItemModels;
    private RecyclerView recyclerView;
    private RecyclerViewItemAdapter recyclerViewItemAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private NestedScrollView bottomSheetLayout;
    private BottomSheetBehavior bottomSheetBehavior;
    private int goBack =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setData();
        setAdapter();
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(this);
        recyclerViewItemAdapter = new RecyclerViewItemAdapter(ItemModels,this,recyclerView,bottomSheetBehavior,bottomSheetLayout);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewItemAdapter);
    }

    private void setData() {
        ItemModels.add(new ItemModel("Pen",R.drawable.pen));
        ItemModels.add(new ItemModel("Pencil",R.drawable.pencil));
        ItemModels.add(new ItemModel("Book",R.drawable.openbook));
        ItemModels.add(new ItemModel("Eraser",R.drawable.eraser));
        ItemModels.add(new ItemModel("Eraser",R.drawable.eraser));
        ItemModels.add(new ItemModel("Eraser",R.drawable.eraser));
    }

    private void init() {
        ItemModels = new ArrayList<>();
        recyclerView = findViewById(R.id.StoreItemList);
        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
    }

    @Override
    public void onBackPressed() {
        goBack++;
        if (goBack == 1) {
            if (bottomSheetBehavior!=null && bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                goBack = 0;
                return;
            }
        }
        if (goBack == 1 || goBack > 1) {
            goBack = 0;
            super.onBackPressed();
        }
    }
}
