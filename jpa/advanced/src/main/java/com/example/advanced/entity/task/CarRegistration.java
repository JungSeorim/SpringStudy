package com.example.advanced.entity.task;

import com.example.advanced.entity.CarOwner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TBL_CAR_REGISTRATION")
@Getter @Setter @ToString
public class CarRegistration {
    @Id
    @GeneratedValue
    private Long carRegistrationId;

    private LocalDateTime carReleaseDate;
    private LocalDateTime carUpDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_OWNER_ID")
    private CarOwner carOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;
}
