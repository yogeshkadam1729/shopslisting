package com.roboelectric.shopslisting.service;

import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.entity.Shops;
import com.roboelectric.shopslisting.mapper.ShopsMapper;
import com.roboelectric.shopslisting.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public List<ShopsDTO> getAllShops()
    {
        List<Shops>  shops = shopRepository.findAll();
        List<ShopsDTO> shopsDTOS = shops.stream().map(e-> ShopsMapper.INSTANCE.mapShopstoShopsDTO(e)).collect(Collectors.toList());
        return shopsDTOS;
    }

    public ShopsDTO getShopById(int id)
    {
        Optional<Shops> shop = shopRepository.findById(id);
        if(shop.isEmpty()) return null;
        return ShopsMapper.INSTANCE.mapShopstoShopsDTO(shop.get());

    }
    public ShopsDTO addShop(ShopsDTO shopsDTO)
    {
        Shops shop = shopRepository.save(ShopsMapper.INSTANCE.mapShopsDTOToShops(shopsDTO));
        return ShopsMapper.INSTANCE.mapShopstoShopsDTO(shop);
    }
}
