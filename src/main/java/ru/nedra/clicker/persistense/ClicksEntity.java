package ru.nedra.clicker.persistense;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clicks_table")
public class ClicksEntity {

    public ClicksEntity(String applicationName, Long clicksCount) {
        this.applicationName = applicationName;
        this.clicksCount = clicksCount;
    }

    public ClicksEntity() { }

    @Id
    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "clicks_count")
    private Long clicksCount;

    public Long getClicksCount() {
        return clicksCount;
    }

    public void setClicksCount(Long clicksCount) {
        this.clicksCount = clicksCount;
    }
}
