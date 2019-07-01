package com.example.spacetraders190502.Model;

public class CurrentItem {
    private GoodsList item;

    public CurrentItem(GoodsList item) {
        this.setItem(item);
    }

    public GoodsList getItem() {
        return item;
    }

    public void setItem(GoodsList item) {
        this.item = item;
    }
}
