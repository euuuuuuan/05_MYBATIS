package com.ohgiraffers.common;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class EmpDTO {
    private String deptId;
    private String deptTitle;

    private EmpDTO empList;
}
