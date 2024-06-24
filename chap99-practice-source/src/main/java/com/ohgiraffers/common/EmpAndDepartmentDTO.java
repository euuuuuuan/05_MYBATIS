package com.ohgiraffers.common;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmpAndDepartmentDTO {
    private String empId;
    private String empName;
    private String deptTitle;
    private String locationId;

    private EmpDTO empList;
}
