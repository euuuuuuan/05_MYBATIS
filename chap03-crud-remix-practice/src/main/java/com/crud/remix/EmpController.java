package com.crud.remix;

import java.util.List;
import java.util.Map;

public class EmpController {
    private final PrintResult printResult;
    private final EmpService empService;

    // 생성자 주입
    public EmpController() {
        printResult = new PrintResult();
        empService = new EmpService();
    }

    // 전체 직원 조회
    public void sellectAllEmp() {
        List<EmpDTO> empList = empService.sellectAllEmp();

        if (empList != null) {
            printResult.printEmpList(empList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }


    public void selectEmpByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        EmpDTO emp = empService.selectEmpByCode(code);

        if (emp != null) {
            printResult.printEmp(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectEmpByName(Map<String, String> parameter) {
        String name = parameter.get("name");

        EmpDTO emp = empService.selectEmpByName(name);

        if (emp != null) {
            printResult.printEmp(emp); // 이것은 왜 석섹스가 아닌것인가
        } else {
            printResult.printErrorMessage("selectName");
        }
    }

    public void registEmp(Map<String, String> parameter) {
        String empId = parameter.get("empId");
        String name = parameter.get("name");
        int salary = Integer.parseInt(parameter.get("salary"));

        EmpDTO emp = new EmpDTO();
        emp.setEmpId(empId);
        emp.setEmpName(name);
        emp.setSalary(salary);

        if (empService.registEmp(emp)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyEmp(Map<String, String> parameter) {
        String empId = parameter.get("empId");
        String name = parameter.get("name");
        int salary = Integer.parseInt(parameter.get("salary"));

        EmpDTO emp = new EmpDTO();
        emp.setEmpId(empId);
        emp.setEmpName(name);
        emp.setSalary(salary);

        if (empService.modifyEmp(emp)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteEmp(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        if (empService.deleteEmp(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
