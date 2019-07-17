package com.example.storerequisition.Model;

public class ItemModel {
    private String ItemName;
    private int ItemIcon;

    public ItemModel(String itemName, int itemIcon) {
        ItemName = itemName;
        ItemIcon = itemIcon;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemIcon() {
        return ItemIcon;
    }

    public void setItemIcon(int itemIcon) {
        ItemIcon = itemIcon;
    }
}
