package com.crud.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpController empController = new EmpController();

        do {
            System.out.println("========= 띠로리 직원 관리 =========");
            System.out.println("1. 전체 직원 조회하기");
            System.out.println("2. 직원 코드로 조회하기");
            System.out.println("3. 직원 이름으로 조회하기");
            System.out.println("4. 직원 정보 추가");
            System.out.println("5. 직원 정보 수정");
            System.out.println("6. 직원 정보 삭제");
            System.out.print("선택할 번호를 입력해주세요: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no) {
                case 1:
                    empController.sellectAllEmp();
                    break;
                case 2:
                    empController.selectEmpByCode(inputEmpCode());
                    break;
                case 3:
                    empController.selectEmpByName(inputEmpName());
                    break;
                case 4:
                    empController.registEmp(inputEmpInfo());
                    break;
                case 5:
                    empController.modifyEmp(inputModifyEmp());
                    break;
                case 6:
                    empController.deleteEmp(inputEmpCode());
                    break;
                default:
                    System.out.println("잘못된 번호를 선택했습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputModifyEmp() {
        Scanner sc = new Scanner(System.in);

        String empId = sc.nextLine();
        System.out.println("수정할 직원 번호를 입력하세요.");
        String name = sc.nextLine();
        System.out.println("수정할 직원 이름를 입력하세요.");
        String salary = sc.nextLine();
        System.out.println("수정할 직원 급여를 입력하세요.");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("name", name);
        parameter.put("salary", salary);
        return parameter;
    }

    private static Map<String, String> inputEmpInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 직원 번호를 입력하세요.");
        String empId = sc.nextLine();
        System.out.println("추가할 직원 이름를 입력하세요.");
        String name = sc.nextLine();
        System.out.println("추가할 직원 주민번호를 입력하세요.");
        String empNo = sc.nextLine();
        System.out.println("추가할 직원 직급코드를 입력하세요.");
        String jobCode = sc.nextLine();
        System.out.println("추가할 직원 급여등급을 입력하세요.");
        String salLevel = sc.nextLine();
        System.out.println("추가할 직원 급여를 입력하세요.");
        String salary = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("name", name);
        parameter.put("empNo", empNo);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);
        parameter.put("salary", salary);
        return parameter;
    }

    private static Map<String, String> inputEmpName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 이름을 입력하세요: ");
        String name = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);

        return parameter;
    }

    /* 제네릭(generic) 타입을 사용하여 타입을 지정하는 부분.
     Map<String, String>은 키와 값이 모두 String 타입인 맵을 의미*/
    private static Map<String, String> inputEmpCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 코드를 입력하세요: ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }
}
