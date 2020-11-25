package io.petstore.pet;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static com.insider.config.Configuration.getPetStoreUrl;
import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    @BeforeClass
    public RequestSpecification initRestAssured() {
        RestAssured.baseURI = getPetStoreUrl();
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }
}