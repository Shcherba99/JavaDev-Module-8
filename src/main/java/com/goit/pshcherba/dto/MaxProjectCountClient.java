package com.goit.pshcherba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MaxProjectCountClient {
    private String name;
    private int projectCount;
}
