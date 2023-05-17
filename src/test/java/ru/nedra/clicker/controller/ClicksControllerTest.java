package ru.nedra.clicker.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.nedra.clicker.service.ClicksService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@DisplayName("Проверка работы контроллера")
public class ClicksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClicksService service;

    @Test
    void getClickCountTest() throws Exception {
        when(service.getActualClicksCount()).thenReturn(9L);

        mockMvc.perform(get("/rest/clicks"))
                .andExpect(status().isOk())
                .andExpect(content().string("9"));
    }

    @Test
    void postClickTest() throws Exception {
        when(service.submitClick()).thenReturn(88L);

        mockMvc.perform(post("/rest/click"))
                .andExpect(status().isOk())
                .andExpect(content().string("88"));
    }


    @Test
    void resetClicksTest() throws Exception {
        mockMvc.perform(delete("/rest/clicks"))
                .andExpect(status().isOk());
    }
}
