package com.insider.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobDto {

    private String position;
    private String department;
    private String location;

}
