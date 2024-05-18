package com.roboelectric.shopslisting.mapper;

import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.entity.Shops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopsMapper {
    ShopsMapper INSTANCE = Mappers.getMapper(ShopsMapper.class);

    Shops mapShopsDTOToShops(ShopsDTO shopsDTO);

    ShopsDTO mapShopstoShopsDTO(Shops shops);

}
