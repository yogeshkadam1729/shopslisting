package com.roboelectric.shopslisting.repo;

import com.roboelectric.shopslisting.entity.ServiceAvailable;

import java.util.List;
import java.util.Set;

public interface ServiceAvailableCustomRepository {

    public Set<ServiceAvailable> getShopsBasedOnDeviceId(int deviceId);

    public Set<ServiceAvailable> getDevicesSupportedBasedOnShopId(int shopId);
}
