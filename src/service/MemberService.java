package service;

import dto.MemberDTO;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    private static String loginEmail = null;
    private static List<String> mEmailList = new ArrayList<>();


    public void save() {
        boolean checkResult = false;
        // do while 안에서 선언하면 while문을 벗어났을 때 사용하지 못하여 전역변수로 선언
        String memberEmail = null;
        do {
            System.out.print("이메일: ");
            memberEmail = scanner.next();
            // 사용가능: true, 중복: false 리턴
            checkResult = memberRepository.emailCheck(memberEmail);
            if (checkResult) {
                System.out.println("사용 가능한 이메일 입니다.");
            } else {
                System.out.println("이미 사용 중인 이메일 입니다.");
            }
        } while (!checkResult); // 사용가능이면 비밀번호를 받아야 하므로 반복문 종료
        System.out.print("비밀번호: ");
        String memberPassword = scanner.next();
        System.out.print("이름: ");
        String memberName = scanner.next();
        System.out.print("전화번호: ");
        String memberMobile = scanner.next();
        MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
        boolean result = memberRepository.save(memberDTO);
        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    }

    public void login() {

        if(loginEmail == null) {
            System.out.print("로그인 이메일: ");
            String mEmail = scanner.next();

            System.out.print("로그인 비밀번호: ");
            String mPassword = scanner.next();

            MemberDTO loginResult = memberRepository.login(mEmail, mPassword);

            if (loginResult != null) {
                System.out.println("로그인 성공");
                loginEmail = mEmail;
            } else {
                System.out.println("로그인 실패");
            }
        }
        else {
                System.out.println("현재  " + loginEmail + "  로그인 상태입니다");
            }
    }


    public void findAll() {

        List<MemberDTO> memberDTOList = memberRepository.findAll();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println("memberDTO = " + memberDTO);
        }

    }


    public void delete() {

        if (loginEmail == null) {
            System.out.println("로그인하세요!!");
        } else {
            System.out.print("비밀번호 입력하세요 : ");
            String mPassword2 = scanner.next();

            MemberDTO memberDTO = memberRepository.findById(loginEmail, mPassword2);

            if (memberDTO == null) {
                System.out.println("비밀번호 오류");
            } else {
                boolean del = memberRepository.delete(loginEmail, mPassword2);
                if (del) {
                    System.out.println("탈퇴 완료");
                    loginEmail = null;
                }
                else System.out.println("해당 정보가 없습니다");
            }
        }
    }

   public void update() {

            System.out.print("수정할 이메일: ");
            String mEmail = scanner.next();

            System.out.print("수정할 비밀번호: ");
            String mPassword = scanner.next();

            MemberDTO memberDTO = memberRepository.findById(mEmail, mPassword);

            if (memberDTO == null) {
                System.out.println("해당 정보가 없습니다");
            } else {
                System.out.print("변경할 전화번호:   ");
                String mobile = scanner.next();
                memberRepository.update(mEmail, mPassword, mobile);
            }
        }

        public void logout () {
            System.out.println("아이디:  "+ loginEmail + "  로그아웃");
            loginEmail = null;
        }
    }