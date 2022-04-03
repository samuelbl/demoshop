package com.samuelapp.demoshop.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.dto.EmployeeDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void sholdReturn200toGetEmployees() throws Exception {
        URI uri = new URI("/employees/");
        mockMvc
                .perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void sholdReturnEmployeeJhon() throws Exception {
        Employee employee = Employee.builder().id(1).name("Jhon").build();
        URI uri = new URI("/employees/"+employee.getId());
        String result = mockMvc
                .perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.readValue(result, Employee.class).getName(),employee.getName());
    }

    @Test
    @Order(3)
    void sholdReturnNotFound() throws Exception {
        URI uri = new URI("/employees/2");
        mockMvc
                .perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(4)
    void shouldSaveNewEmployeeAndReturn201() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .name("Maria").idEmployeType(1).idShop(1).address("Test Street")
                .telephone("4899184578").employmentDate(LocalDate.of(2020, 1, 8)).build();
        URI uri = new URI("/employees/");
        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(5)
    void sholdUpdateEmployee() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .name("Jhon after update").idEmployeType(1).idShop(1).address("Test Street")
                .telephone("4899184578").employmentDate(LocalDate.of(2020, 1, 8)).build();
        URI uri = new URI("/employees/1");
        mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk());
        String employeeUpdated = mockMvc
                .perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.readValue(employeeUpdated, Employee.class).getName(),employeeDto.getName());
    }

    @Test
    @Order(6)
    void sholdRemoveEmployee() throws Exception {
        URI uri = new URI("/employees/2");
        mockMvc
                .perform(delete(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}