package main;

import service.StudentService;

import java.util.Scanner;

public class MainClass {
    // 스캐너를 이용하여
    // 1. 학생등록
    // 2. 학생상세조회
    // 3. 학생목록조회
    // 를 선택하는 코드를 작성합시다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean run = true;
        while (run) {
            System.out.println("====== 학생관리 ======");
            System.out.println("1.학생등록 2.학생조회 3.학생목록 4.정보수정 5.정보삭제 0.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("학생등록 메뉴");
                studentService.save();
            } else if (sel == 2) {
                System.out.println("학생조회 메뉴");
                studentService.findById();
                /*
                    service 의 findById 메서드를 호출함.

                    service의 findById
                    - id값을 입력받고 repository의 findById로 id값을 넘김
                    - 입력받은 id에 해당하는 학생 데이터를 리턴받음.
                    - 리턴받은 값을 출력함.
                 */
            } else if (sel == 3) {
                System.out.println("학생목록 메뉴");
                studentService.findAll();
                  /*  findAll() 메서드
                        Main에서 3번 선택시 호출되는 메서드
                        매개변수 리턴 없음.
                        실행내용
                        - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
                        - 리턴받은 리스트에 담긴 데이터를 for문을 이용하여 출력함.
                 */

            } else if (sel == 4) {
                System.out.println("학생수정 메뉴");
                studentService.update();
                /*  수정기능
                전화번호만 수정함
                수정기능 선택하면 전화번호 입력 받고 입력받은 정보로 변경함
                List에서 수정을 워하는 매서드는 따로 없고 덮어쓰기 한다고 생각 */

            } else if (sel == 5) {
                System.out.println("학생삭제 메뉴");
                studentService.delete();

                /* 삭제기능
                삭제할 id를 입력받고 해당 데이터를 리스트에서 삭제
                삭제할때는 리스트의 인덱스로 접근해야함 */

            } else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}