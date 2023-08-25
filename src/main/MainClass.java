package main;
import dto.MemberDTO;
import service.MemberService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberDTO memberDTO = new MemberDTO();
        MemberService memberService = new MemberService();

        boolean run = true;
        while (run) {
            System.out.println("====== 회원정보관리 ======");
            System.out.println("1. 회원가입 2.로그인 3.회원목록조회 4.회원정보수정 5.회원탈퇴 6. 로그아웃  0.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("회원등록 메뉴");
                memberService.save();
            } else  if (sel == 2) {
                System.out.println("로그인 메뉴");
                memberService.login();
            } else if (sel == 3) {
                System.out.println("회원목록조회 메뉴");
                memberService.findAll();
            } else if (sel == 4) {
                System.out.println("회원정보수정 메뉴");
                memberService.update();
            } else if (sel == 5) {
                System.out.println("회원탈퇴 메뉴");
                memberService.delete();
            } else if (sel == 6) {
                    System.out.println("로그아웃 메뉴");
                    memberService.logout();
            }  else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}


