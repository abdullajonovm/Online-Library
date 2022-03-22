package com.example.onlinekutubxona.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private String name;
    private Double price;
    private Integer categoryId;
}
