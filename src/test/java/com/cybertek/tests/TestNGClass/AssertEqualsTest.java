package com.cybertek.tests.TestNGClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertEqualsTest {


    @Test
    public void test(){
        String expected="Google";
        String actual="Google";

//        if(actual.equals(expected)){
//            System.out.println("PASS");
//        }else {
//
//            System.out.println("FAIL");
//            System.out.println("Actual: "+actual);
//            System.out.println("Expected: "+expected);
//        }
        System.out.println("first annotation ");
        Assert.assertEquals(1,1);
        System.out.println("second annotation");
        Assert.assertEquals(actual,expected);
        System.out.println("done");

    }
    @Test
    public void test2() {
        String expected = "Google";
        String actual = "Google";

//        if(actual.equals(expected)){
//            System.out.println("PASS");
//        }else {
//
//            System.out.println("FAIL");
//            System.out.println("Actual: "+actual);
//            System.out.println("Expected: "+expected);
//        }
        System.out.println("first annotation ");
        Assert.assertEquals(1, 1);
        System.out.println("second annotation");
        Assert.assertEquals(actual, expected);
        System.out.println("done");

    }
        @AfterMethod
    public void tearDown(){
        System.out.println("reporting");


    }

}
