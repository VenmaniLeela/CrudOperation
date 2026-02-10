package com.example.task.DTO;

import lombok.Data;

@Data
public class AddItemDTO {

    private String name;
    private String description;
    private double price;
    private String category;
}
