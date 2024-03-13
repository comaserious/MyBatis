package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.Map;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {

        /*필기. myBatis 의 동적 SQL 확인하기*/

        Scanner scr = new Scanner(System.in);

        do{
            System.out.println("===================MyBatis 동적 SQL===================");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 :
                    ifSubMenu();
                    break;
                case 2 : break;
                case 3 : break;
                case 4 : break;
                case 9 :
                    System.out.println("시스템을 종료합니다"); return;
                default:
                    System.out.println("잘못입력하셨습니다 다시 입력해주세요"); break;
            }



        }while(true);



    }

    private static void ifSubMenu() {

        Scanner scr = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("================if 서브 메뉴==================");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 ");
            System.out.print("원하는 메뉴를 선택하세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1 : menuService.selectMenuByPrice(inputPrice());break;
                case 2 : menuService.searchMenu(inputSearchCriteria()); break;
                case 9 : return;

            }
        }while(true);
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner scr = new Scanner(System.in);
        System.out.print("검색 기준을 입력해주세요 (name or category) : ");
        String condition = scr.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = scr.nextLine();


      return new SearchCriteria(condition,value);
    }

    private static int inputPrice() {

        Scanner scr = new Scanner(System.in);
        System.out.print("메뉴의 최대가격을 적으시오 : ");
        int price = scr.nextInt();

        return price;
    }
}
