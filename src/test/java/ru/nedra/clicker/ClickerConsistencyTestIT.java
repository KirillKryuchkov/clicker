package ru.nedra.clicker;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nedra.clicker.controller.ClicksController;
import ru.nedra.clicker.persistense.ClicksRepository;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Тест")
public class ClickerConsistencyTestIT {

    @Autowired
    private ClicksController controller;

    @Autowired
    private ClicksRepository repository;

    @Test
    public void consistencyTest() throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100 ; i++) {
            executorService.execute(() -> controller.postClick());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        assertEquals(100, repository.getClicksCount());
        repository.resetClicks();
    }
}
