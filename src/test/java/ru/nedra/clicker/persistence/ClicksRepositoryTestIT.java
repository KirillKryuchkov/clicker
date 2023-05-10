package ru.nedra.clicker.persistence;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nedra.clicker.persistense.ClicksEntity;
import ru.nedra.clicker.persistense.ClicksRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Тест работоспособности репозитория")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClicksRepositoryTestIT {

    @Autowired
    private ClicksRepository repository;

    @Test
    @Order(1)
    @DisplayName("Имя теста")
    void createClicksEntityTest() {
        ClicksEntity entity = new ClicksEntity("clicker-test", 0L);

        assertDoesNotThrow(() -> repository.save(entity));
    }

    @Test
    @Order(2)
    void createClicksEntity() {
        ClicksEntity entity = assertDoesNotThrow(() -> repository.findFirstByApplicationName("clicker-test"));

        assertEquals(0L, entity.getClicksCount());
    }

    @Test
    @Order(3)
    void deleteClicksEntity() {
        ClicksEntity entity = assertDoesNotThrow(() -> repository.findFirstByApplicationName("clicker-test"));

        assertDoesNotThrow(() ->repository.delete(entity));
    }
}
