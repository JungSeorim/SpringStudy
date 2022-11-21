package com.example.advanced.repository.task;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.advanced.entity.task.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findByCarName(@Param("carName") String carName);

    @Query("select c from Car c join fetch c.carOwner")
    public List<Car> findAllFetchJoin();

    @Override
    @EntityGraph(attributePaths = "carOwner")
    public List<Car> findAll();

    @EntityGraph(attributePaths = "carOwner")
    @Query("select c from Car c where c.carOwner= :carName")
    public List<Car> findAllWithOwner(String carName);
}
