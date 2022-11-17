package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import com.example.intermediate.entity.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class ComputerRepositoryTest {
    @Autowired
    private DesktopRepository desktopRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void saveTest(){
        Phone phone = new Phone();
        Desktop desktop = new Desktop();

        desktop.create("QHD+", "삼성","콩순이",800000L, LocalDateTime.now(),"8GB","512","1080","i7",LocalDateTime.now(),LocalDateTime.of(2022,12,25,0,0),"COX 청축");
        phone.create("OLED", "애플","앱등",1400000L, LocalDateTime.now(),"8GB","256","1080","i7",LocalDateTime.now(),LocalDateTime.of(2022,11,16,0,0),"배터리 빵빵");

        assertThat(desktopRepository.save(desktop).getComputerName()).isEqualTo("콩순이");
        assertThat(phoneRepository.save(phone).getComputerName()).isEqualTo("앱등");
    }
}
