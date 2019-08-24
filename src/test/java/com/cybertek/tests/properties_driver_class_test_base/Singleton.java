package com.cybertek.tests.properties_driver_class_test_base;

public class Singleton {

    private static String string;

private Singleton(){

}

    public static String getInstance(){
        if(string==null){
            string=" i have value now";
        }else{
            System.out.println("Already has value");
        }
        return string;
    }
}
