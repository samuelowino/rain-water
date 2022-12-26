package com.owino.securityapp.api_tests;

import com.owino.securityapp.controllers.HolidaysController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HolidaysController.class)
@Import(HolidaysController.class)
@ExtendWith(SpringExtension.class)
public class HolidaysApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_NotListHolidaysToUnAuthenticatedPersons_Test() throws Exception {
        mockMvc.perform(get("/holidqays"))
                .andExpect(status().isUnauthorized())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void should_ListApiCapabilitiesWithoutAuthentication_Test() throws Exception {
        mockMvc.perform(get("/feature"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
