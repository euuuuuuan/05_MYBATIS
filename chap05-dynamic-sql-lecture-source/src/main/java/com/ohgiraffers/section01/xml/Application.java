package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("============= MyBatis 동적 SQL (조건문) =============");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("5. 종료하기");
            System.out.println("메뉴를 선택하세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1: ifSubMenu(); break;
                case 2: chooseSubMenu(); break;
                case 3: forEachSubName(); break;
                case 4: break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        } while (true);
    }

    private static void forEachSubName() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("=========== forEach 서브메뉴 ===========");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력하세요");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList());
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private static List<Integer> createRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int temp = ((int) (Math.random() * 23)) + 1;
            set.add(temp);
        }

    }

    private static void chooseSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("=========== choose 서브메뉴 ===========");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력하세요");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuBySubCategory(inputSubCategory());
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private static SearchCriteria inputSubCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("상위 분류를 입력해주세요.(식사, 음료, 디저트)");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("=========== if 서브메뉴 ===========");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 또는 카테고리명으로 검색하여 메뉴목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력하세요");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.selectMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요(name or category): ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력해주세요: ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 가격의 최대 금액을 입력하세요: ");
        int price = sc.nextInt();

        return price;
    }
}
