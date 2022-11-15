package com.example.basic.domain.entity;

import com.example.basic.repository.MemberDAO;
import com.example.basic.repository.SuperCarDAO;
import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarTest {
    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
        SuperCar superCar1 = new SuperCar();
        SuperCar superCar2 = new SuperCar();
        SuperCar superCar3 = new SuperCar();

        superCar1.setSuperCarName("BUGATTI");
        superCar1.setSuperCarBrand("부가티");
        superCar1.setSuperCarColor("black");
        superCar1.setSuperCarPrice(8000000000L);

        superCar2.setSuperCarName("Maserati");
        superCar2.setSuperCarBrand("마세라티");
        superCar2.setSuperCarColor("white");
        superCar2.setSuperCarPrice(300000000L);

        superCar3.setSuperCarName("McLaren");
        superCar3.setSuperCarBrand("맥라렌");
        superCar3.setSuperCarColor("RED");
        superCar3.setSuperCarPrice(330000000L);

        superCarDAO.save(superCar1);
        superCarDAO.save(superCar2);
        superCarDAO.save(superCar3);
    }

    @Test
    public void deleteTest(){
        superCarDAO.delete(superCarDAO.findById(2L));
    }

    @Test
    public void findByIdTest(){
        log.info("member: " + Optional.ofNullable(superCarDAO.findById(1L)).orElseGet(SuperCar::new));
    }

}
