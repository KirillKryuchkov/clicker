package ru.nedra.clicker.persistense;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClicksRepository extends CrudRepository<ClicksEntity, String> {

    @Query(value = "UPDATE clicks_table SET clicks_count = clicks_count + 1 WHERE application_name = 'clicker' RETURNING clicks_count", nativeQuery = true)
    Long incrementAndGetClickCount();

    @Query(value = "SELECT clicks_count FROM clicks_table WHERE application_name = 'clicker'", nativeQuery = true)
    Long getClicksCount();

    @Query(value = "UPDATE clicks_table SET clicks_count = 0 WHERE application_name = 'clicker' RETURNING clicks_count", nativeQuery = true)
    void resetClicks();

}
