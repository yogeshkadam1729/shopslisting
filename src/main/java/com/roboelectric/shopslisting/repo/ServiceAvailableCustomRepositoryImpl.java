package com.roboelectric.shopslisting.repo;

import com.roboelectric.shopslisting.entity.ServiceAvailable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceAvailableCustomRepositoryImpl implements ServiceAvailableCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<ServiceAvailable> getShopsBasedOnDeviceId(int deviceId) {

        Query q = entityManager.createNamedQuery("ServiceAvailable.findByDevice");
        q.setParameter(1, deviceId);
        List result = q.getResultList();
        Set<ServiceAvailable> finalResult = new HashSet<>(result);
        return finalResult;
    }

    @Override
    public Set<ServiceAvailable> getDevicesSupportedBasedOnShopId(int shopId) {
        Query q = entityManager.createNamedQuery("ServiceAvailable.findByShop");
        q.setParameter(1, shopId);
        List result = q.getResultList();
        Set<ServiceAvailable> finalResult = new HashSet<>(result);
        return finalResult;
    }
}
