package com.insider.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Job {

    private String position;
    private String department;
    private String location;

}
