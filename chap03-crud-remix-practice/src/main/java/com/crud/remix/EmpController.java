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
}
