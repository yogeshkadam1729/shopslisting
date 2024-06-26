package com.roboelectric.shopslisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCatalougeDTO {
    private Set<DeviceDTO> devices;
    private ShopsDTO shop;
}
