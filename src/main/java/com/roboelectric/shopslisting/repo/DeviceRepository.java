package com.roboelectric.shopslisting.repo;

import com.roboelectric.shopslisting.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {

}
