package com.roboelectric.shopslisting.mapper;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    Device mapDeviceDTOToDevice(DeviceDTO deviceDTO);

    DeviceDTO mapDeviceToDeviceDTO(Device device);

}
