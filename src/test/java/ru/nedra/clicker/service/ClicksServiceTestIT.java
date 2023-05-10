package ru.nedra.clicker.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Тест работы сервиса")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClicksServiceTestIT {

    @Autowired
    private ClicksService service;

    @Test
    @Order(1)
    void submitClickTest() {
        Long newClicksCount = assertDoesNotThrow(() -> service.submitClick());

        assertEquals(1, newClicksCount);
    }

    @Test
    @Order(2)
    void multipleSubmitClickTest() {
        assertDoesNotThrow(() -> service.submitClick());
        assertDoesNotThrow(() -> service.submitClick());
        assertDoesNotThrow(() -> service.submitClick());

        Long newClicksCount = assertDoesNotThrow(() -> service.submitClick());

        assertEquals(5, newClicksCount);
    }

    @Test
    @Order(3)
    void getActualClicksCountTest() {
        Long clicksCount = assertDoesNotThrow(() -> service.getActualClicksCount());

        assertEquals(5, clicksCount);
    }

    @Test
    @Order(4)
    void resetClicksTest() {
        Long clicksCount = assertDoesNotThrow(() -> service.resetClicks());

        assertEquals(5, clicksCount);
    }

    @Test
    @Order(5)
    void getActualClicksCountAfterResetTest() {
        Long clicksCount = assertDoesNotThrow(() -> service.getActualClicksCount());

        assertEquals(0, clicksCount);
    }
}
