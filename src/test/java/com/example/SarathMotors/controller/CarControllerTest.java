package com.example.SarathMotors.controller;

import com.example.SarathMotors.entity.Cars;
import com.example.SarathMotors.service.CarAvailabilityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarAvailabilityService mockCarAvailabilityService;

    @Test
    void testAddCar() throws Exception {
        // Setup
        // Configure CarAvailabilityService.addCars(...).
        final Cars cars = new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus");
        when(mockCarAvailabilityService.addCars(new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date",
                "availabilityStatus"))).thenReturn(cars);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sarathrentals/addcars")
                        .content(asJsonString(cars)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Cars cars) {
        try{
            return new ObjectMapper().writeValueAsString(cars);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void testGetAll() throws Exception {
        // Setup
        // Configure CarAvailabilityService.getAll(...).
        final List<Cars> cars = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));
        when(mockCarAvailabilityService.getAll()).thenReturn(cars);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sarathrentals/getall")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAll_CarAvailabilityServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCarAvailabilityService.getAll()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sarathrentals/getall")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetCarByDate() throws Exception {
        // Setup
        // Configure CarAvailabilityService.getCarByDate(...).
        final List<Cars> cars = List.of(
                new Cars(0L, "carName", "price", "brand", "color", "noOfSeats", "date", "availabilityStatus"));
        when(mockCarAvailabilityService.getCarByDate("date")).thenReturn(cars);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sarathrentals/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetCarByDate_CarAvailabilityServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCarAvailabilityService.getCarByDate("date")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sarathrentals/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
