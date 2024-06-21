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


    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "insert":
                successMessage = "신규 직원 등록을 성공했습니다.";
                break;
            case "update":
                successMessage = "직원 정보 수정을 성공했습니다.";
                break;
            case "delete":
                successMessage = "직원 정보 삭제를 성공했습니다.";
                break;
        }
        System.out.println(successMessage);
    }
}
