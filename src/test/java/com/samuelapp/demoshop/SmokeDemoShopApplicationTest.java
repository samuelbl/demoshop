package com.samuelapp.demoshop;

import com.samuelapp.demoshop.controler.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class SmokeDemoShopApplicationTest {

    @Autowired
    EmployeeController controller;

	@Test
	void contextLoads() {
       assertThat(controller).isNotNull();
	}

}
