package com.example.spacetraders190502.Model;

public class CurrentItem {
    private GoodsList item;

    public CurrentItem(int order) {
        switch (order) {
            case 0:
                item = GoodsList.WATER;
                break;
            case 1:
                item = GoodsList.FURS;
                break;
            case 2:
                item = GoodsList.FOOD;
                break;
            case 3:
                item = GoodsList.ORE;
                break;
            case 4:
                item = GoodsList.GAMES;
                break;
            case 5:
                item = GoodsList.FIREARMS;
                break;
            case 6:
                item = GoodsList.MEDICINE;
                break;
            case 7:
                item = GoodsList.MACHINES;
                break;
            case 8:
                item = GoodsList.NARCOTICS;
                break;
            case 9:
                item = GoodsList.ROBOTS;
                break;
        }
    }

    public GoodsList getItem() {
        return item;
    }

    public void setItem(GoodsList item) {
        this.item = item;
    }
}
