package com.goit.pshcherba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker {
    private int id;
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

    public Worker(String name, LocalDate birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }
}
