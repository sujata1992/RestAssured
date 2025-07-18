package com.api.test.base;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.config;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import com.api.test.ConfigReader;

public class BaseSetUp {

    @BeforeSuite
    public static void setUp() {
        String env= ConfigReader.get("env");
        if (env.equalsIgnoreCase("prod")) {
            RestAssured.baseURI = ConfigReader.get("prodUrl");
        } else {
            RestAssured.baseURI = ConfigReader.get("url");
        }
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

    }
}
