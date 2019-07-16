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
    public void testGetNameByOrderOne() {
        String one = GoodsList.getNameByOrder(0);
        boolean conditionOne = one.equals("Water");
        Assert.assertTrue(conditionOne);
    }

    @Test
    public void testGetNameByOrderTwo() {
        String two = GoodsList.getNameByOrder(4);
        boolean conditionTwo = two.equals("Games");
        Assert.assertTrue(conditionTwo);
    }

    @Test
    public void testSpecialResources() {
        int testCaseOne = testGoodOne.specialResources(testGoodOne.getCr(),testGoodOne.getBasePrice(testGoodOne.getMtlp()));
        boolean conditionThree = (testCaseOne == 22);
        Assert.assertTrue(conditionThree);
    }

}
