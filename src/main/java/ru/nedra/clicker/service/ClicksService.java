package ru.nedra.clicker.service;

import org.springframework.stereotype.Service;
import ru.nedra.clicker.persistense.ClicksEntity;
import ru.nedra.clicker.persistense.ClicksRepository;

@Service
public class ClicksService {

    private static final String APP_NAME = "clicker";

    private final ClicksRepository repository;

    public ClicksService(ClicksRepository repository) {
        this.repository = repository;
    }

    public Long getActualClicksCount() {
        return repository.findFirstByApplicationName(APP_NAME).getClicksCount();
    }

    public Long submitClick() {
        final ClicksEntity entity = repository.findFirstByApplicationName(APP_NAME);
        Long clicksCount = entity.getClicksCount();

        entity.setClicksCount(++clicksCount);
        repository.save(entity);

        return entity.getClicksCount();
    }

    public Long resetClicks() {
        final ClicksEntity entity = repository.findFirstByApplicationName(APP_NAME);
        Long clicksCount = entity.getClicksCount();

        entity.setClicksCount(0L);
        repository.save(entity);

        return clicksCount;
    }
}
