package com.jumia.exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.jumia.exercise.data.MockData.getCustomers;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class JumiaIntegrationTests extends JumiaApplicationTests {

    @BeforeEach
    public void setup() {
        super.setUp();
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void getAllCustomers() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)))
                .andExpect(jsonPath("$[0].id", is(getCustomers().get(0).getId())))
                .andExpect(jsonPath("$[0].name", is(getCustomers().get(0).getName())))
                .andExpect(jsonPath("$[0].phone", is(getCustomers().get(0).getPhone())));
    }

    @Test
    public void getAllCustomersTrueState() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .param("valid", String.valueOf(true))
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getAllCustomersFalseState() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .param("valid", String.valueOf(false))
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getAllCustomersCameroon() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .param("country", "0")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getAllCustomersInCameroonTrueState() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .param("valid", String.valueOf(true))
                .param("country", "0")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getAllCustomersInCameroonFalseState() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/customer")
                .param("valid", String.valueOf(false))
                .param("country", "0")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }


}