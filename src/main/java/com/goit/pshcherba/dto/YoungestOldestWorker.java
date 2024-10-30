package com.goit.pshcherba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class YoungestOldestWorker {
    private String type;
    private String name;
    private LocalDate birthday;
}
