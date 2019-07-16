package com.example.spacetraders190502;


import com.example.spacetraders190502.Model.GoodsList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DivijUnitTests {

    private GoodsList testGoodOne;



    @Before
    public void setUp() {
        testGoodOne = GoodsList.WATER;
    }

    @Test
    public void testGetNameByOrderZero() {
        String one = GoodsList.getNameByOrder(0);
        boolean conditionOne = one.equals("Water");
        Assert.assertTrue(conditionOne);
    }

    @Test
    public void testGetNameByOrderOne() {
        String two = GoodsList.getNameByOrder(1);
        boolean conditionTwo = two.equals("Furs");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderTwo() {
        String two = GoodsList.getNameByOrder(2);
        boolean conditionTwo = two.equals("Food");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderThree() {
        String two = GoodsList.getNameByOrder(3);
        boolean conditionTwo = two.equals("Ore");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderFour() {
        String two = GoodsList.getNameByOrder(4);
        boolean conditionTwo = two.equals("Games");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderFive() {
        String two = GoodsList.getNameByOrder(5);
        boolean conditionTwo = two.equals("Firearms");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderSix() {
        String two = GoodsList.getNameByOrder(6);
        boolean conditionTwo = two.equals("Medicine");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderSeven() {
        String two = GoodsList.getNameByOrder(7);
        boolean conditionTwo = two.equals("Machines");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderEight() {
        String two = GoodsList.getNameByOrder(8);
        boolean conditionTwo = two.equals("Narcotics");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testGetNameByOrderNine() {
        String two = GoodsList.getNameByOrder(9);
        boolean conditionTwo = two.equals("Robots");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testSpecialResourcesOne() {
        int testCaseOne = testGoodOne.specialResources(testGoodOne.getCr(),testGoodOne.getBasePrice(testGoodOne.getMtlp()));
        boolean conditionThree = (testCaseOne == 22);
        Assert.assertTrue(conditionThree);
    }

    @Test
    public void testSpecialResourcesTwo() {
        int testCaseOne = testGoodOne.specialResources(testGoodOne.getEr(),testGoodOne.getBasePrice(testGoodOne.getMtlp()));
        boolean conditionThree = (testCaseOne == 40);
        Assert.assertTrue(conditionThree);
    }

}
