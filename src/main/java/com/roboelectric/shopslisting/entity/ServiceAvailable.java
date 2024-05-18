package com.roboelectric.shopslisting.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_available")
@NamedNativeQuery(name = "ServiceAvailable.findByShop", query = "SELECT * FROM service_available WHERE shop_id = ?", resultClass = ServiceAvailable.class)
@NamedNativeQuery(name = "ServiceAvailable.findByDevice", query = "SELECT * FROM service_available WHERE device_id = ?", resultClass = ServiceAvailable.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAvailable {

    @EmbeddedId
    ServiceAvailableKey id;

    @ManyToOne
    @MapsId("shopId")
    @JoinColumn(name = "shop_id")
    Shops shop;

    @ManyToOne
    @MapsId("deviceId")
    @JoinColumn(name = "device_id")
    Device device;

    private int rating;
}
