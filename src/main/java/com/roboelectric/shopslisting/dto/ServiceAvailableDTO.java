package com.roboelectric.shopslisting.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceAvailableDTO {

    private int deviceId;
    private  int shopId;
    private int ratings;
}
