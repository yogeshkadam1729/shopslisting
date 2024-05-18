package com.roboelectric.shopslisting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    private String deviceName;
    @Enumerated(EnumType.STRING)
    private DeviceCategory deviceCategory;
    private String deviceNo;

    @OneToMany(mappedBy = "device")
    Set<ServiceAvailable> serviceAvailables;


}
