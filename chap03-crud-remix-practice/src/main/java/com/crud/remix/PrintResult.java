package com.crud.remix;

import java.util.List;

public class PrintResult {
    public void printEmpList(List<EmpDTO> empList) {
        for (EmpDTO emp : empList) {
            System.out.println(emp);
        }
    }

    public void printEmp(EmpDTO emp) {
        System.out.println(emp);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "selectList":
                errorMessage = "직원 목록 조회를 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }


}
