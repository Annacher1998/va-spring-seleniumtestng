package com.cybertek.tests.TestNGClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MixedAnnotationTest {

@BeforeMethod
public void setUp(){
    System.out.println("openning browser");
}
    @AfterMethod
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
@Test(priority = 2)
    public void test3(){
    System.out.println("\t testing test case 3");
}
    @Test(priority = 1)
    public void test4() {
        System.out.println("\t testing test case 4");
    }
}
