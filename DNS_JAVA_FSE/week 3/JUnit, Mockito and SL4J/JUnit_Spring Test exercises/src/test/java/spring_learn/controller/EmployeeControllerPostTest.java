package spring_learn.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import spring_learn.model.Employee;
import spring_learn.service.EmployeeService;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerPostTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private EmployeeService service;


    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void testCreateEmployee() throws Exception {


        Employee emp = new Employee();

        emp.setId(1L);
        emp.setName("Rahul");
        emp.setEmail("rahul@gmail.com");


        when(service.saveEmployee(any(Employee.class)))
                .thenReturn(emp);



        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)))

                .andExpect(status().isOk())

                .andExpect(jsonPath("$.id").value(1))

                .andExpect(jsonPath("$.name").value("Rahul"))

                .andExpect(jsonPath("$.email").value("rahul@gmail.com"));

    }

}