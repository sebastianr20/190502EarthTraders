package com.example.spacetraders190502;

import com.example.spacetraders190502.Model.Difficulty;
import com.example.spacetraders190502.Model.GoodsList;
import com.example.spacetraders190502.Model.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MorganTest {
    private GoodsList testedGood;
    private  Player player;

    @Before
    public void setUp() {
        player = new Player("Morgan", 4, 4, 4, 4, Difficulty.NORMAL);
        testedGood = GoodsList.ORE;
    }

    @Test
    public void tooManyGoodsTest() {
        boolean condOne = player.getPlayerGoods().size() >= 21;
        Assert.assertFalse(condOne);
    }
    @Test
    public void badCreditTest() {
        boolean condTwo = player.getCreditScore() < testedGood.getPrice();
        Assert.assertFalse(condTwo);
    }
    @Test
    public void correctMethodTest() {
        boolean condThree = player.canBuy(testedGood);
        Assert.assertTrue(condThree);
    }

    @Test
    public void cannotBuyTest() {
        boolean condFour = player.getPlayerGoods().size() >= 21 || player.getCreditScore() < testedGood.getPrice();
        Assert.assertFalse(condFour);
    }

    @Test
    public void checkCreditTest() {
        int creditScore = player.getCreditScore();
        player.buy(testedGood);
        boolean condFive = player.getCreditScore() == creditScore - testedGood.getPrice();
        Assert.assertTrue(condFive);
    }

    @Test
    public void goodAddedTest() {
        int quantity = testedGood.getQuantity();
        player.buy(testedGood);
        boolean condSix = testedGood.getQuantity() == quantity;
        Assert.assertFalse(condSix);
    }

    @Test
    public void quantityTest() {
        int quantity = testedGood.getQuantity();
        player.buy(testedGood);
        boolean condSix = testedGood.getQuantity() == quantity + 1;
        Assert.assertTrue(condSix);
    }

}
