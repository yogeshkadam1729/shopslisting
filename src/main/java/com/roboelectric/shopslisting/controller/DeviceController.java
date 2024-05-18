package com.roboelectric.shopslisting.controller;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.dto.UserDTO;
import com.roboelectric.shopslisting.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/device")
@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/getAllDevices")
    public ResponseEntity<List<DeviceDTO>> getAllDevices()
    {
        return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
    }

    @GetMapping("/getDevice/{id}")
    public ResponseEntity<DeviceDTO> getDevice(@PathVariable int id)
    {
        return new ResponseEntity<>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    @PostMapping("/addDevice")
    public ResponseEntity<DeviceDTO> addDevice(@RequestBody DeviceDTO deviceDTO)
    {
        return new ResponseEntity<>(deviceService.addDevice(deviceDTO),HttpStatus.CREATED);
    }
}
