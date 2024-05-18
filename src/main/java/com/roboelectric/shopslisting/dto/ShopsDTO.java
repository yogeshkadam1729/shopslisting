package com.roboelectric.shopslisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopsDTO {

    private int id;
    private String name;
    private String address;
    private String city;
    private String shopDescription;
}
