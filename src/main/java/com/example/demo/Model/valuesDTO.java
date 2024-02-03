package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class valuesDTO {
    private String code;
    private String description;
    private Integer qty;
    private Double unitPrice;
}
