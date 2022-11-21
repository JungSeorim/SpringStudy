package com.example.advanced.entity.task;

import com.example.advanced.entity.CarOwner;
import com.example.advanced.entity.Pet;
import com.example.advanced.type.CarBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="TBL_CAR")
@Getter @Setter @ToString
public class Car {
    @Id @GeneratedValue
    private Long carId;

    private CarBrand carBrand;
    private String carName;
    private String carColor;
    private Long carPrice;
    private LocalDateTime carReleaseDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<CarRegistration> carRegistration;
}
