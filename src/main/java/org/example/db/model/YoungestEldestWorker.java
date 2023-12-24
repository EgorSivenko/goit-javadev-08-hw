package org.example.db.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class YoungestEldestWorker {
    private String type;
    private String workerName;
    private LocalDate birthday;
}
