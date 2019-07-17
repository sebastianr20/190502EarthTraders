package com.example.spacetraders190502;

import com.example.spacetraders190502.Model.Difficulty;
import com.example.spacetraders190502.Model.GoodsList;
import com.example.spacetraders190502.Model.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class SamiTest {
    private int good = 0;
    private GoodsList testGood;
    private  Player p;
    private ArrayList<GoodsList> list = new ArrayList<>();

    @Before
    public void setUp() {
        p = new Player("Sami", 4, 4, 4, 4, Difficulty.EASY);
        testGood = GoodsList.WATER;

    }

    @Test
    public void playerHasTooManyGoodsTest() {
        boolean firstCond = p.getPlayerGoods().size() >= 21;
        Assert.assertFalse(firstCond);
    }

    @Test
    public void playerCreditScoreTooLow() {
        boolean secondCond = p.getCreditScore() < testGood.getPrice();
        Assert.assertFalse(secondCond);
    }
    @Test
    public void methodWorksTest() {
        boolean thirdCond = p.canBuy(good);
        Assert.assertTrue(thirdCond);
    }
    @Test
    public void goodNotFoundTest() {
        boolean cond1 = !list.contains(testGood);
        Assert.assertTrue(cond1);
    }

    @Test
    public void goodFoundToSellTest() {
        list.add(testGood);
        boolean cond2 = list.contains(testGood);
        Assert.assertTrue(cond2);
    }


}
