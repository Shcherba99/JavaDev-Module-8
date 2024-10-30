package com.goit.pshcherba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    private int id;
    private String name;

    public Client(String name) {
        this.name = name;
    }
}
