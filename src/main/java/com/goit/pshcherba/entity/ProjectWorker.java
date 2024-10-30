package com.goit.pshcherba.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectWorker {
    private int projectId;
    private int workerId;
}
