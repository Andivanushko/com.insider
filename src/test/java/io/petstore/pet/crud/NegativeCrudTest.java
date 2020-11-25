package io.petstore.pet.crud;

import io.petstore.pet.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeCrudTest extends BaseTest {

    @Test(description = "Get NOT FOUND response when trying to GET pet by invalid Id")
    public void error404GetRequest() {
        given()
                .when()
                .get("pet/1")
                .then().assertThat()
                .statusCode(404);
    }

    @Test(description = "Get NOT FOUND response when trying to DELETE pet by invalid Id")
    public void error404DeleteRequest() {
        initRestAssured()
                .when()
                .delete("pet/" + 1)
                .then()
                .assertThat().statusCode(404);
    }
}
