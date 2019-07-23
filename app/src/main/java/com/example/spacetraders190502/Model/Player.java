package com.example.spacetraders190502.Model;
import java.util.ArrayList;

import android.util.Log;

public class Player {
    private String name;
    private int skillPilot;
    private int skillFighter;
    private int skillEngineer;
    private int skillTrader;
    private Difficulty diffLevel;
    private int creditScore;
    private Spaceship currShip;
    private int totalPoints;
    private int cargoSpace;
    private ArrayList<GoodsList> playerGoods;


    public int getSkillPilot() {
        return skillPilot;
    }

    public int getSkillFighter() {
        return skillFighter;
    }

    public int getSkillTrader() {
        return skillTrader;
    }

    public int getSkillEngineer() {
        return skillEngineer;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDiffLevel() {
        return diffLevel;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public Spaceship getSpaceship() {
        return currShip;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }


    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public ArrayList<GoodsList> getPlayerGoods() {
        return playerGoods;

    }

    public Player(String name, int skillPilot, int skillFighter, int skillTrader, int skillEngineer, Difficulty diffLevel) {
        this.name = name;
        this.skillPilot = skillPilot;
        this.skillEngineer = skillEngineer;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.diffLevel = diffLevel;
        this.totalPoints = 16;
        this.playerGoods = new ArrayList<>(20);
        this.creditScore = 1000;
        this.currShip = Spaceship.GNAT;
        Log.i("Player created", this.toString());
    }

    @Override
    public String toString() {
        return String.format("Player %s has been created! Your skills are:\n" +
                        "Pilot: %d\nFighter: %d \nTrader: %d\nEngineer: %d\n" +
                        "Difficulty Level:  %s\nCredits: %d\nShip: %s", this.getName(),
                this.getSkillPilot(), this.getSkillFighter(), this.getSkillTrader(), this.getSkillEngineer(),
                this.getDiffLevel().getReturnDifficulty(), this.getCreditScore(), this.getSpaceship().getName());

    }

    public int calculatePointsLeft() {
        totalPoints -= skillTrader;
        totalPoints -= skillFighter;
        totalPoints -= skillPilot;
        totalPoints -= skillEngineer;
        return totalPoints;
    }

    //can buy
    public boolean canBuy(int goodOrder) {
        String s = GoodsList.getNameByOrder(goodOrder);
        GoodsList good = GoodsList.valueOf(s.toUpperCase());
        if (playerGoods.size() + 1 > 20) {
            return false;
        } else if (this.getCreditScore() < good.getPrice()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean canBuy(GoodsList good) {
        if (playerGoods.size() + 1 > 20) {
            return false;
        } else if (this.getCreditScore() < good.getPrice()) {
            return false;
        } else {
            return true;
        }
    }

    //can sell
    public boolean canSell(GoodsList good) {
        if (!playerGoods.contains(good)) {
            return false;
        } else {
            return true;
        }
    }

    //the buying process
    public boolean buy(GoodsList good) {
        if (canBuy(good) == false) {
            return false;
        } else {
            this.setCreditScore(this.creditScore -= good.getPrice());
            playerGoods.add(good);
        }
        good.setQuantity(good.getQuantity() + 1);
        return true;
    }

    public String getItemName(int order) {
        return GoodsList.getNameByOrder(order);
    }

    public void addToPlayerGoods(String good) {
        playerGoods.add(GoodsList.valueOf(good));
    }

    public void removeFromPlayerGoods(String good) {
        playerGoods.remove(GoodsList.valueOf(good));
    }




    //the selling process
    public boolean sell(GoodsList good) {
        this.setCreditScore(creditScore += good.getPrice());
        good.setQuantity(good.getQuantity() - 1);
        playerGoods.remove(good);
        return true;



    }
    public void setCurrShip(Spaceship ship) {
        currShip = ship;
    }
}