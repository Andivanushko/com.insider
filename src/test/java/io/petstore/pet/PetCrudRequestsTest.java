package io.petstore.pet;

import io.petstore.BaseApiTest;
import io.petstore.model.request.PetDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetCrudRequestsTest extends BaseApiTest {

    @Test(description = "Try to find pet with invalid Id")
    public void getPetByInvalidId() {
        given()
                .when()
                .get("pet/1")
                .then().assertThat()
                .statusCode(404);
    }

    @Test(description = "Try to add pet with invalid PetDto data")
    public void addPetToStoreWithInvalidDto() {
        given()
                .body(new PetDto.Builder()
                        .name("Wah")
                        .build())
                .when()
                .post("pet")
                .then()
                .assertThat()
                .statusCode(415);
    }

}