package com.roboelectric.shopslisting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@Embeddable
public class ServiceAvailableKey implements Serializable {
    @Column(name = "shop_id")
    int shopId;

    @Column(name = "device_id")
    int deviceId;

}
