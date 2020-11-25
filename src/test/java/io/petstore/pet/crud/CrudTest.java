package io.petstore.pet.crud;

import io.petstore.model.request.Category;
import io.petstore.model.request.PetDto;
import io.petstore.model.request.Tag;
import io.petstore.model.response.PetDtoResponse;
import io.petstore.pet.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class CrudTest extends BaseTest {

    private static final int RANDOM_INT = new Random().nextInt(100);
    private static final String STRING = "string";

    private PetDtoResponse response;

    @BeforeMethod
    public PetDtoResponse addedPetToStore() {
        return initRestAssured()
                .body(buildPetDto())
                .when()
                .post("pet")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(PetDtoResponse.class);
    }

    @Test(description = "Add a new pet to the store")
    @Description("Execute POST request for pet endpoint")
    public void addPet() {
        assertEquals(buildPetDto().getId(), addedPetToStore().getId(), "Pet ID fields are not equals");
        assertEquals(buildPetDto().getName(), addedPetToStore().getName(), "Pat name fields are not equals");
    }

    @Test(description = "Deletes a pete")
    @Description("Execute DELETE request for pet endpoint")
    public void deletePet() {
        initRestAssured()
                .when()
                .delete("pet/" + addedPetToStore().getId())
                .then()
                .assertThat().statusCode(200);
    }

    @Test(description = "Update an existing pet")
    @Description("Execute PUT request for pet endpoint")
    public void updatePet() {
         response = initRestAssured()
                .body(buildUpdatedPetDto(buildPetDto()))
                .when()
                .put("pet")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(PetDtoResponse.class);

        assertEquals(response.getName(), buildUpdatedPetDto(buildPetDto()).getName(), "Pet name fields are not equals");
    }

    @Test(description = "Find pet by ID")
    @Description("Execute GET request for pet endpoint")
    public void getPet() {
        response = initRestAssured()
                .when()
                .get("pet/" + addedPetToStore().getId())
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(PetDtoResponse.class);

        assertEquals(response.getId(), addedPetToStore().getId(), "Pet ID fields are not equals");
        assertEquals(response.getName(), addedPetToStore().getName(), "Pet name fields are not equals");
    }

    private PetDto buildPetDto() {
        return PetDto.builder()
                .id(RANDOM_INT)
                .category(Category.builder()
                        .id(RANDOM_INT)
                        .name(STRING).build())
                .name("Dobby" + RANDOM_INT)
                .photoUrls(Collections.singletonList(STRING))
                .tags(Collections.singletonList(Tag.builder()
                        .id(RANDOM_INT)
                        .name(STRING).build()))
                .status("available").build();
    }

    private PetDto buildUpdatedPetDto(PetDto petDto) {
        return petDto.builder().id(RANDOM_INT).name("NewDobby").build();
    }

}