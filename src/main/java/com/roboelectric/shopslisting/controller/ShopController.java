package com.roboelectric.shopslisting.controller;

import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.entity.Shops;
import com.roboelectric.shopslisting.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
@CrossOrigin
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/getAllShops")
    public ResponseEntity<List<ShopsDTO>> getAllShops()
    {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @GetMapping("/getShop/{id}")
    public ResponseEntity<ShopsDTO> getShop(@PathVariable int id)
    {
        return new ResponseEntity<>(shopService.getShopById(id), HttpStatus.OK);
    }

    @PostMapping("/createShop")
    public ResponseEntity<ShopsDTO> createShop(@RequestBody ShopsDTO shopsDTO)
    {
        return new ResponseEntity<>(shopService.addShop(shopsDTO),HttpStatus.CREATED);
    }



}
