package com.cybertek.tests.TestNGClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

    @Test
    public void test(){
        System.out.println("\tHello Anna");
        System.out.println("\topening browser");
        System.out.println("\ttesting test case 1");

    }


    @Test
    public void test2(){
        System.out.println("\tsetting path");
        System.out.println("\topening browser");
        System.out.println("\ttesting test case 2");

    }


    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser");
    }

}
