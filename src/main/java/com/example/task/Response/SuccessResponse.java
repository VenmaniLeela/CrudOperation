package com.example.task.Response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"statusCode", "statusMessage", "data"})
public class SuccessResponse<T> implements Serializable {
    private int statusCode = 200;
    private String statusMessage = "Success";
    private transient T data;

}
