package com.example.spacetraders190502.Model;

public enum TechLevel {
    PreAgriculture(0),
    Agriculture(1),
    Medieval(2),
    Renaissance(3),
    EarlyIndustrial(4),
    Industrial(5),
    PostIndustrial(6),
    HiTech(7);

    private int order;

    TechLevel(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}


