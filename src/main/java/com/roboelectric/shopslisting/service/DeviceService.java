package com.roboelectric.shopslisting.service;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.dto.UserDTO;
import com.roboelectric.shopslisting.entity.Device;
import com.roboelectric.shopslisting.entity.User;
import com.roboelectric.shopslisting.mapper.DeviceMapper;
import com.roboelectric.shopslisting.mapper.UserMapper;
import com.roboelectric.shopslisting.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    public List<DeviceDTO> getAllDevices()
    {
        List<Device>  devices = deviceRepository.findAll();
        List<DeviceDTO> deviceDTOS = devices.stream().map(e-> DeviceMapper.INSTANCE.mapDeviceToDeviceDTO(e)).collect(Collectors.toList());
        return deviceDTOS;
    }

    public DeviceDTO getDeviceById(int id)
    {
        Optional<Device> device = deviceRepository.findById(id);
        if(device.isEmpty()) return null;
        return DeviceMapper.INSTANCE.mapDeviceToDeviceDTO(device.get());

    }
    public DeviceDTO addDevice(DeviceDTO deviceDTO)
    {
        Device device = deviceRepository.save(DeviceMapper.INSTANCE.mapDeviceDTOToDevice(deviceDTO));
        return DeviceMapper.INSTANCE.mapDeviceToDeviceDTO(device);
    }
}
