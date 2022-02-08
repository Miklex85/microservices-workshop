package com.nuuptech.training.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto implements Serializable {

    private String id;

    private String errorMessage;

    private List<String> errors;

    public ErrorDto(String id, String errorMessage) {
        this.id = id;
        this.errorMessage = errorMessage;
    }

    public ErrorDto(String id, List<String> errors) {
        this.id = id;
        this.errors = errors;
    }
}

