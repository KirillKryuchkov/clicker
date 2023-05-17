package ru.nedra.clicker.service;
import org.springframework.stereotype.Service;
import ru.nedra.clicker.persistense.ClicksRepository;

@Service
public class ClicksService {

    private final ClicksRepository repository;

    public ClicksService(ClicksRepository repository) {
        this.repository = repository;
    }

    public Long getActualClicksCount() {
        return repository.getClicksCount();
    }

    public Long submitClick() {
        return repository.incrementAndGetClickCount();
    }

    public void resetClicks() {
        repository.resetClicks();
    }
}
