package com.example.intermediate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity @Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DEVICE_KINDNESS")
@Table(name="TBL_COMPUTER")
@Getter @Setter @ToString
@NoArgsConstructor
public class Computer {
    @Id
    @GeneratedValue
    @Column(name="COMPUTER_ID")
    private Long computerId;

    @Column(name="COMPUTER_SCREEN")
    private String computerScreen;

    @Column(name="COMPUTER_BRAND")
    private String computerBrand;

    @Column(name="COMPUTER_NAME")
    private String computerName;

    @Column(name="COMPUTER_PRICE")
    private Long computerPrice;

    @Column(name="COMPUTER_RELEASE_DATE")
    private LocalDateTime computerReleaseDate;

    @Column(name="COMPUTER_RAM")
    private String computerRam;

    @Column(name="COMPUTER_SSD")
    private String computerSsd;

    @Column(name="COMPUTER_GPU")
    private String computerGpu;

    @Column(name="COMPUTER_PROCESSOR")
    private String computerProcessor;

    @Column(name="COMPUTER_CREATED_DATE")
    private LocalDateTime computerCreatedDate;

    @Column(name="COMPUTER_UPDATED_DATE")
    private LocalDateTime computerUpdatedDate;

    public void create(String computerScreen, String computerBrand, String computerName, Long computerPrice, LocalDateTime computerReleaseDate, String computerRam, String computerSsd, String computerGpu, String computerProcessor, LocalDateTime computerCreatedDate, LocalDateTime computerUpdatedDate) {
        this.computerScreen = computerScreen;
        this.computerBrand = computerBrand;
        this.computerName = computerName;
        this.computerPrice = computerPrice;
        this.computerReleaseDate = computerReleaseDate;
        this.computerRam = computerRam;
        this.computerSsd = computerSsd;
        this.computerGpu = computerGpu;
        this.computerProcessor = computerProcessor;
        this.computerCreatedDate = computerCreatedDate;
        this.computerUpdatedDate = computerUpdatedDate;
    }
}
