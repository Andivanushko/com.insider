package io.petstore.model.request;

import java.util.List;

public class PetDto {

    public int id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;

    private PetDto(Builder builder) {
        this.name = builder.name;
    }

    public static class Builder {

        private String name;

        public PetDto.Builder name(String name) {
            this.name = name;
            return this;
        }
        public PetDto build() {
            return new PetDto(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}