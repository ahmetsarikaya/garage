package com.pia.garage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GarageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeAllocated1Slot() throws Exception {
        this.mockMvc.perform(post("/garage/park/car?color=Black&plate=34-SO-1988"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Allocated 1 slot(s)")));
    }
    @Test
    public void shouldBeAllocated2Slot() throws Exception {
        this.mockMvc.perform(post("/garage/park/jeep?color=Black&plate=34-SO-1988"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Allocated 2 slot(s)")));
    }
    @Test
    public void shouldBeAllocated4Slot() throws Exception {
        this.mockMvc.perform(post("/garage/park/truck?color=Black&plate=34-SO-1988"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Allocated 4 slot(s)")));
    }
    @Test
    public void shouldBeLeaved1Slot() throws Exception {
        this.mockMvc.perform(delete("/garage/leave/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1 Numbered car leaved.")));
    }
    @Test
    public void shouldBePrintGarageStatus() throws Exception {
        this.mockMvc.perform(get("/garage/status"))
                .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(content().string(containsString("1 Numbered car leaved.")));
    }
}
