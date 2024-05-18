package com.roboelectric.shopslisting.service;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.dto.ServiceAvailableDTO;
import com.roboelectric.shopslisting.dto.ServiceCatalougeDTO;
import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.entity.Device;
import com.roboelectric.shopslisting.entity.ServiceAvailable;
import com.roboelectric.shopslisting.entity.ServiceAvailableKey;
import com.roboelectric.shopslisting.entity.Shops;
import com.roboelectric.shopslisting.mapper.DeviceMapper;
import com.roboelectric.shopslisting.mapper.ShopsMapper;
import com.roboelectric.shopslisting.repo.DeviceRepository;
import com.roboelectric.shopslisting.repo.ServiceAvailableRepository;
import com.roboelectric.shopslisting.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServicesAvailableService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ServiceAvailableRepository serviceAvailableRepository;

    public Set<ShopsDTO> getAvailableShops(int deviceId)
    {
        Set<ServiceAvailable> serviceAvailables = serviceAvailableRepository.getShopsBasedOnDeviceId(deviceId);
        return serviceAvailables.stream().map(e -> ShopsMapper.INSTANCE.mapShopstoShopsDTO(e.getShop())).collect(Collectors.toSet());

    }

    public Set<DeviceDTO> getAvailableDevices(int shopId)
    {
        Set<ServiceAvailable> serviceAvailables = serviceAvailableRepository.getDevicesSupportedBasedOnShopId(shopId);
        return serviceAvailables.stream().map(e-> DeviceMapper.INSTANCE.mapDeviceToDeviceDTO(e.getDevice())).collect(Collectors.toSet());

    }

    public void addServiceToSystem(ServiceAvailableDTO serviceAvailableDTO)
    {
        ServiceAvailable serviceAvailable = new ServiceAvailable();
        ServiceAvailableKey serviceAvailableKey = new ServiceAvailableKey();
        serviceAvailableKey.setDeviceId(serviceAvailableDTO.getDeviceId());
        serviceAvailableKey.setShopId(serviceAvailableDTO.getShopId());
        serviceAvailable.setId(serviceAvailableKey);
        serviceAvailable.setDevice(deviceRepository.findById(serviceAvailableDTO.getDeviceId()).get());
        serviceAvailable.setShop(shopRepository.findById(serviceAvailableDTO.getShopId()).get());
        serviceAvailable.setRating(serviceAvailableDTO.getRatings());
        serviceAvailableRepository.save(serviceAvailable);
    }


    public ServiceCatalougeDTO getShopDetailsAndServices(int id) {
        Shops shops = shopRepository.findById(id).get();
        ShopsDTO shopsDTO = ShopsMapper.INSTANCE.mapShopstoShopsDTO(shops);
        Set<DeviceDTO> devices = getAvailableDevices(id);
        ServiceCatalougeDTO catalougeDTO = new ServiceCatalougeDTO(devices,shopsDTO);
        return catalougeDTO;
    }
}
