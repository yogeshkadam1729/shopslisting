package com.roboelectric.shopslisting.controller;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.entity.DeviceCategory;
import com.roboelectric.shopslisting.entity.DeviceType;
import com.roboelectric.shopslisting.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeviceControllerTest {


    @InjectMocks
    DeviceController deviceController;

    @Mock
    DeviceService deviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void getAllDevices() {

        //Arrange
        List<DeviceDTO> devices = Arrays.asList(
                new DeviceDTO(1, DeviceType.Electrical,"Fan", DeviceCategory.HOME_APPLIANCES,"001"),
                new DeviceDTO(1, DeviceType.Electrical,"Mixure", DeviceCategory.HOME_APPLIANCES,"002")
        );

        //Act
        when(deviceService.getAllDevices()).thenReturn(devices);
        ResponseEntity<List<DeviceDTO>> response = deviceController.getAllDevices();

        //Assert
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(devices,response.getBody());

        //verify test method is called
        verify(deviceService,times(1)).getAllDevices();
    }

    @Test
    void getDevice() {
    }

    @Test
    void addDevice() {
        //Arrange
       DeviceDTO deivce = new DeviceDTO(1, DeviceType.Electrical,"Fan", DeviceCategory.HOME_APPLIANCES,"001");


        //Act
        when(deviceService.addDevice(deivce)).thenReturn(deivce);
        ResponseEntity<DeviceDTO> response = deviceController.addDevice(deivce);

        //Assert
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(deivce,response.getBody());

        //verify test method is called
        verify(deviceService,times(1)).addDevice(deivce);
    }
}