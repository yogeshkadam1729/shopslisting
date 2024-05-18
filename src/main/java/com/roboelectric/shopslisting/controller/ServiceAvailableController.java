package com.roboelectric.shopslisting.controller;

import com.roboelectric.shopslisting.dto.DeviceDTO;
import com.roboelectric.shopslisting.dto.ServiceAvailableDTO;
import com.roboelectric.shopslisting.dto.ServiceCatalougeDTO;
import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.entity.ServiceAvailable;
import com.roboelectric.shopslisting.service.ServicesAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("serviceCatalouge")
@RestController
@CrossOrigin
public class ServiceAvailableController {
    @Autowired
    ServicesAvailableService servicesAvailableService;


    @PostMapping("/addServices")
    public ResponseEntity<?> addDevice(@RequestBody ServiceAvailableDTO serviceAvailableDTO)
    {
        servicesAvailableService.addServiceToSystem(serviceAvailableDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/getShops/{id}")
    public ResponseEntity<Set<ShopsDTO>> getShops(@PathVariable int id)
    {
        return new ResponseEntity<>(servicesAvailableService.getAvailableShops(id), HttpStatus.OK);
    }

    @GetMapping("/getDevices/{id}")
    public ResponseEntity<Set<DeviceDTO>> getDevice(@PathVariable int id)
    {
        return new ResponseEntity<>(servicesAvailableService.getAvailableDevices(id), HttpStatus.OK);
    }

    @GetMapping("/getShopDetailsAndServices/{id}")
    public ResponseEntity<ServiceCatalougeDTO> getShopDetailsAndServices(@PathVariable int id)
    {
        return new ResponseEntity<>(servicesAvailableService.getShopDetailsAndServices(id),HttpStatus.OK);
    }

}
