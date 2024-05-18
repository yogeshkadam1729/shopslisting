package com.roboelectric.shopslisting.dto;

import com.roboelectric.shopslisting.entity.DeviceCategory;
import com.roboelectric.shopslisting.entity.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
    private int id;
    private DeviceType deviceType;
    private String deviceName;
    private DeviceCategory deviceCategory;
    private String deviceNo;
}
