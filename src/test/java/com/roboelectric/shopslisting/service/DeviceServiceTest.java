package com.roboelectric.shopslisting.service;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.entity.*;
import com.roboelectric.shopslisting.mapper.DeviceMapper;
import com.roboelectric.shopslisting.repo.DeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeviceServiceTest {

    @InjectMocks
    DeviceService deviceService;

    @Mock
    DeviceRepository deviceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDevices() {

        //Arrange
        List<Device> mockDevices = Arrays.asList(
                new Device(1, DeviceType.Electrical,"Fan", DeviceCategory.HOME_APPLIANCES,"001",new HashSet<>(Arrays.asList(
                        new ServiceAvailable(new ServiceAvailableKey(),new Shops(1,"Vishwas Electric","123","Mumbai","abc",null),
                                new Device(1,DeviceType.Electrical,"Fan", DeviceCategory.HOME_APPLIANCES,"001",null),1))))

        );

        //Act
        when(deviceRepository.findAll()).thenReturn(mockDevices);
        List<DeviceDTO> deviceList = deviceService.getAllDevices();

        //Assert
        assertEquals(deviceList.size(),mockDevices.size());
        for(int i = 0; i<mockDevices.size();i++)
        {
            DeviceDTO deviceDTO = DeviceMapper.INSTANCE.mapDeviceToDeviceDTO(mockDevices.get(i));
            assertEquals(deviceDTO,deviceList.get(i));
        }

        //verify test method is called
        verify(deviceRepository,times(1)).findAll();
    }

    @Test
    void getDeviceById() {
    }

    @Test
    void addDevice() {
    }
}