package com.cybertek.tests.TestNGClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AsserTrueTest {


    @Test
    public void test(){
        System.out.println(1==2);
       Assert.assertTrue(1==1);

       String url="https://www.google.com";
       String expStr=".com";

       Assert.assertTrue(url.endsWith(expStr));

       Assert.assertTrue(true);


    }

    @Test
    public void test2(){

        //verify url does not end with .com
        String url="https://www.google.com";
        String exp=".com";
//expected condition is false
        //if the result is false it will pass
       // Assert.assertFalse(url.endsWith(exp));

        Assert.assertFalse(false);
    }

}
