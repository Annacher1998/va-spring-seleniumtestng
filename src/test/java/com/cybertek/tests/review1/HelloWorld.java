package com.cybertek.tests.review1;
import com.github.javafaker.Faker;
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.color().name());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.chuckNorris().fact());


    }
}
