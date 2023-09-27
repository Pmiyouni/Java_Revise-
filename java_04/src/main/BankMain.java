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
            System.out.println("1. 신규계좌 등록 2. 계좌 조회 3. 비밀번호 변경 4. 잔액조회  5.입금  6.출금  7.입출금 내역 조회 8. 샘플데이터 0.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            switch(sel){
            case 1:
                System.out.println("신규계좌등록 메뉴");
                bankService.accountInsert();
                break;
            case 2:
                System.out.println("계좌 조회 메뉴");
                bankService.accoutFind();
                break;
            case 3:
                System.out.println("비밀번호 변경 메뉴");
                bankService.updataPassword();
                break;
            case 4:
                System.out.println("잔액조회 메뉴");
                bankService.findByAccount();
                break;
            case 5:
                System.out.println("입금 메뉴");
                bankService.depositAccount();
                break;
            case 6:
                System.out.println("출금 메뉴");
                bankService.withdrawAccount();
                break;
            case 7:
                System.out.println("입출금내역 조회 메뉴");
                bankService.findAll();
                break;
            case 8:
                System.out.println("샘플데이터 완성");
                bankService.sampleData();
                break;
            case 0:
                System.out.println("종료");
                run = false;
                break;
            default :
                System.out.println("메뉴선택오류! 다시 입력하세요");
            }
        }
    }
}


