package io.petstore;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeMethod;

import static com.insider.config.Configuration.getPetStoreUrl;

public abstract class BaseApiTest {

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = getPetStoreUrl();
        RestAssured.registerParser("application/json", Parser.JSON);
    }
}