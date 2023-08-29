package main;

import service.BankService;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        boolean run = true;
        while (run) {
            System.out.println("\n====== 은행 프로젝트 ======");
            System.out.println("1. 신규계좌 등록 2. 잔액조회  3.입금 4.출금 5.입출금 내역 조회 0.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("신규계좌등록 메뉴");
                bankService.accountInsert();
            } else  if (sel == 2) {
                System.out.println("잔액조회 메뉴");
                bankService.findByAccount();
            } else if (sel == 3) {
                System.out.println("입금 메뉴");
                bankService.depositAccount();
            } else if (sel == 4) {
                System.out.println("출금 메뉴");
                bankService.withdrawAccount();
            } else if (sel == 5) {
                System.out.println("입출금내역 조회 메뉴");
                bankService.findAll();
            }  else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}


