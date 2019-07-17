package com.example.spacetraders190502;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.GoodsList;
import com.example.spacetraders190502.Model.Region;
import com.example.spacetraders190502.Model.Spaceship;
import com.example.spacetraders190502.Model.TechLevel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;

public class JUnitSebastian {
    @Before
    public void setUp() {
        ArrayList<GoodsList> list = new ArrayList<>();
        list.add(GoodsList.WATER);
        list.add(GoodsList.FURS);
        list.add(GoodsList.FOOD);
        list.add(GoodsList.ORE);
        list.add(GoodsList.GAMES);
        list.add(GoodsList.FIREARMS);
        list.add(GoodsList.MEDICINE);
        list.add(GoodsList.MACHINES);
        list.add(GoodsList.NARCOTICS);
        list.add(GoodsList.ROBOTS);
    }

    @Test
    public void testRandomizePriceWater() {
        GoodsList good = GoodsList.WATER;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceFurs() {
        GoodsList good = GoodsList.FURS;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceFood() {
        GoodsList good = GoodsList.FOOD;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceOre() {
        GoodsList good = GoodsList.ORE;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceGames() {
        GoodsList good = GoodsList.GAMES;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceFirearms() {
        GoodsList good = GoodsList.FIREARMS;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceMedicine() {
        GoodsList good = GoodsList.MEDICINE;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceGamesMachines() {
        GoodsList good = GoodsList.MACHINES;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceNarcotics() {
        GoodsList good = GoodsList.NARCOTICS;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testRandomizePriceRobots() {
        GoodsList good = GoodsList.ROBOTS;
        int basePrice = 100;
        int randomPrice = good.randomizePrice(basePrice);
        int variation = good.getVar();
        Assert.assertTrue(good.getName() + " Random exceeds lower boundary.",
                randomPrice >= basePrice - variation);
        Assert.assertTrue(good.getName() + " Random exceeds higher boundary.",
                randomPrice <= basePrice + variation);
    }

    @Test
    public void testCanSellTrue() {
        GoodsList good = GoodsList.MEDICINE;
        boolean test = good.canSell(TechLevel.EarlyIndustrial);
        Assert.assertTrue("Must be true.", test);
        test = good.canSell(TechLevel.Industrial);
        Assert.assertTrue("Must be true", test);
        test = good.canSell(TechLevel.PostIndustrial);
        Assert.assertTrue("Must be true", test);
        test = good.canSell(TechLevel.HiTech);
        Assert.assertTrue("Must be true", test);
    }

    @Test
    public void testCanSellFalse() {
        GoodsList good = GoodsList.MEDICINE;
        boolean test = good.canSell(TechLevel.Renaissance);
        Assert.assertFalse("Must be false.", test);
        test = good.canSell(TechLevel.Medieval);
        Assert.assertFalse("Must be false.", test);
        test = good.canSell(TechLevel.Agriculture);
        Assert.assertFalse("Must be false.", test);
        test = good.canSell(TechLevel.PreAgriculture);
        Assert.assertFalse("Must be false.", test);
    }
}
