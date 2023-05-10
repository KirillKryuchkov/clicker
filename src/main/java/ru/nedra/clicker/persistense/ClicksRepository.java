package ru.nedra.clicker.persistense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClicksRepository extends CrudRepository<ClicksEntity, String> {

    ClicksEntity findFirstByApplicationName(String applicationName);
}
