package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class UsesTestBaseTest2 extends TestBase {

    @Test
    public void test1(){
        driver.get("http://etsy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

}
