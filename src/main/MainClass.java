package main;

import dto.BoardDTO;
import service.BoardService;
import service.MemberService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService=new MemberService();
        BoardService boardService = new BoardService();

        boolean run = true;
        while (run) {
            System.out.println("\n=======  회 원 관 리  &  게 시 판 ======");
            System.out.println("1. 회원정보관리로 이동  2. 게시판으로 이동  0.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            switch (sel) {
                case 1:
                    System.out.println("====== 회원정보관리 ======");
                    System.out.println("1. 회원가입 2.로그인 3.회원목록조회 4.회원정보수정 5.회원탈퇴 6. 로그아웃  0.메인으로 이동");
                    System.out.print("선택>  ");
                    int sel = scanner.nextInt();
                    if (sel == 1) {
                        System.out.println("회원등록 메뉴");
                        memberService.save();
                        //                   }
//                    else if (sel == 2) {
//                        System.out.println("로그인 메뉴");
//                        memberService.login();
//                    } else if (sel == 3) {
//                        System.out.println("회원목록조회 메뉴");
//                        memberService.findAll();
//                    } else if (sel == 4) {
//                        System.out.println("회원정보수정 메뉴");
//                        memberService.update();
//                    } else if (sel == 5) {
//                        System.out.println("회원탈퇴 메뉴");
//                        memberService.delete();
//                    } else if (sel == 6) {
//                        System.out.println("로그아웃 메뉴");
//                        memberService.logout();
                    } else if (sel == 0) {
                        System.out.println("메인으로 이동");

                    }


                case 2:
                    System.out.println("\n====== 게  시  판 ======");
                    System.out.println("1. 글작성 2.글목록 3.글조회 4.글수정 5.글삭제 6. 검색 7. 샘플데이터  0.메인으로 이동");
                    System.out.print("선택>  ");
                    int sel = scanner.nextInt();
                    if (sel == 1) {
                        System.out.println("글작성 메뉴");
                        boardService.save();
//                        BoardDTO boardDTO = new BoardDTO();
//                        System.out.println("boardDTO = " + boardDTO);
//                    } else if (sel == 2) {
//                        System.out.println("글목록 메뉴");
//                        boardService.findAll();
//                    } else if (sel == 3) {
//                        System.out.println("글조회 메뉴");
//                        boardService.findById();
//                    } else if (sel == 4) {
//                        System.out.println("글수정 메뉴");
//                        boardService.update();
//                    } else if (sel == 5) {
//                        System.out.println("글삭제 메뉴");
//                        boardService.delete();
//                    } else if (sel == 6) {
//                        System.out.println("검색 메뉴");
//                        boardService.search();
//                    } else if (sel == 7) {
//                        boardService.sampleData();
//                        System.out.println("샘플데이터 작성완료 ");
                    } else if (sel == 0) {
                        System.out.println("메인으로 이동");
                    }
                case 0:
                    System.out.println("프로그램 종료");
                    run = false;
                    break;
                default:
                    System.out.println("메뉴 선택 오류");
            }
        }
    }
}






