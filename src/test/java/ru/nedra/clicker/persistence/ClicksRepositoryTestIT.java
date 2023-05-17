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
    void testIncrementAndGetClickCount() {
        Long a = repository.findById("clicker").get().getClicksCount() + 1;
        Long b = repository.incrementAndGetClickCount();
        assertEquals(a, b);
    }

    @Test
    @Order(3)
    void testGetClicksCount() {
        Long a = repository.getClicksCount();
        Long b = repository.findById("clicker").get().getClicksCount();
        assertEquals(a, b);
    }

    @Test
    @Order(4)
    void testResetClicks() {
        repository.resetClicks();
        assertEquals(0L, repository.findById("clicker").get().getClicksCount());
    }
}


