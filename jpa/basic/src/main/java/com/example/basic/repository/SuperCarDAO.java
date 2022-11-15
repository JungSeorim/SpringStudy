package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.domain.entity.SuperCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SuperCarDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public SuperCar save(SuperCar superCar){
        entityManager.persist(superCar);
        return superCar;
    }

    public void delete(SuperCar superCar){
        entityManager.remove(superCar);
    }

    public SuperCar findById(Long superCarId){
        return entityManager.find(SuperCar.class, superCarId);
    }
}
