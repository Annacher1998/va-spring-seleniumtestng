package com.cybertek.tests.TestNGClass;

import org.testng.annotations.*;

public class MixedAnnotations2Test {




    @BeforeClass
    public void setUpClass(){
        System.out.println("setting path");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("reporting every thing to HR");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("opening browser");
    }
  // @AfterMethod
    public void  tearDown(){
        System.out.println("closing path");
    }

    @Test
    public void test1(){
        System.out.println("\t testing test case 1");
    }


    @Test
    public void test2(){
        System.out.println("\t testing test case 2");

    }


}
