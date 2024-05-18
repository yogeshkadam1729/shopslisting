package com.roboelectric.shopslisting.repo;

import com.roboelectric.shopslisting.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Integer> {
}
