package com.roboelectric.shopslisting.repo;

import com.roboelectric.shopslisting.entity.ServiceAvailable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceAvailableRepository extends JpaRepository<ServiceAvailable,Integer>, ServiceAvailableCustomRepository{

}
