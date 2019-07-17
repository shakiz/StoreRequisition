package com.example.storerequisition;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.storerequisition.Adapter.RecyclerViewItemAdapter;
import com.example.storerequisition.Model.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemModel> ItemModels;
    private RecyclerView recyclerView;
    private RecyclerViewItemAdapter recyclerViewItemAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout bottomSheetLayout;
    private BottomSheetBehavior bottomSheetBehavior;
    private int goBack =0;
    private CoordinatorLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setData();
        setAdapter();
    }

    private void setAdapter() {
        layoutManager = new GridLayoutManager(this,2);
        recyclerViewItemAdapter = new RecyclerViewItemAdapter(ItemModels,this,recyclerView,bottomSheetBehavior,bottomSheetLayout);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewItemAdapter);
    }

    private void setData() {
        ItemModels.add(new ItemModel("Pen",R.drawable.ic_chrome_reader_mode));
        ItemModels.add(new ItemModel("Pencil",R.drawable.ic_chrome_reader_mode));
        ItemModels.add(new ItemModel("Book",R.drawable.ic_chrome_reader_mode));
        ItemModels.add(new ItemModel("Eraser",R.drawable.ic_chrome_reader_mode));
        ItemModels.add(new ItemModel("Paper",R.drawable.ic_chrome_reader_mode));
        ItemModels.add(new ItemModel("Notebook",R.drawable.ic_chrome_reader_mode));
    }

    private void init() {
        ItemModels = new ArrayList<>();
        recyclerView = findViewById(R.id.StoreItemList);
        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        mainLayout = findViewById(R.id.mainLayout);
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
