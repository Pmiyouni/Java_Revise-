package service;

import dto.StudentDTO;
import respository.StudentRepository;

import java.util.List;
import java.util.Scanner;   

public class StudentService {
    Scanner scanner = new Scanner(System.in);
    StudentRepository studentRepository = new StudentRepository();
    // 학생등록 메서드
    // 매개변수 없음.
    // 리턴 없음.
    // 메서드 이름: save()
    // 실행내용
    // 스캐너로 이름(studentName), 학과(studentMajor), 전화번호(studentMobile)를 입력받고
    // 입력값을 DTO객체에 담아서 StudentRepository의 save() 메서드로 전달
    public void save() {
        System.out.print("이름: ");
        String studentName = scanner.next();
        System.out.print("학과: ");
        String studentMajor = scanner.next();
        System.out.print("전화번호: ");
        String studentMobile = scanner.next();
        // DTO 객체
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setStudentName(studentName);
//        studentDTO.setStudentMajor(studentMajor);
//        studentDTO.setStudentMobile(studentMobile);
        StudentDTO  studentDTO = new StudentDTO(studentName, studentMajor, studentMobile);

        // DTO 객체를 StudentRepository의 save() 메서드로 전달하여 리턴을 boolean으로 받음.
        boolean result = studentRepository.save(studentDTO);
        // repository의 save() 내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if (result) {
            System.out.println("등록 성공");
            System.out.println(studentRepository.findAll());
        } else {
            System.out.println("등록 실패");
        }
    }

    public void findAll() {
        // - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
        List<StudentDTO> studentDTOList = studentRepository.findAll();
        for (StudentDTO studentDTO: studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
//        for (int i=0; i<studentDTOList.size(); i++) {
//            System.out.println(studentDTOList.get(i));
//        }
        //하나씩 처리하는 경우
    }


    public void findById() {
        //조회기능 선택시 먼저 목록을 보여준다면 Service클래스에서 findAll()호출
        findAll();

        System.out.print("조회할 id: ");
        long id = scanner.nextLong();
        StudentDTO studentDTO = studentRepository.findById(id);

        if (studentDTO != null) {
            //System.out.println("조회학생정보= " + studentDTO);
            System.out.println("아이디 : " + studentDTO.getId());
            System.out.println("학생이름 : " + studentDTO.getStudentName());
            System.out.println("학생학년 : " + studentDTO.getStudentMajor());
            System.out.println("전화번호 : " + studentDTO.getStudentMobile());
        } else {
            System.out.println("찾는 정보가 없습니다");
        }
      }
    public void delete() {

        System.out.print("삭제할 id: ");
        long id = scanner.nextLong();
        boolean del = studentRepository.delete(id);
        if(del) System.out.println("삭제 완료");
        else System.out.println("해당 정보가 없습니다");

        findAll();
        }


    public void update() {
        // 수정할 id를 입력 받은 뒤 해당 정보가 있으면 수정할 전화번호를 입력받고
        // 해당 정보가 없으면 없다는 출력을 하고 메인메뉴로 돌아감

        findAll();

        System.out.print("수정할 id: ");
        long id = scanner.nextLong();
        StudentDTO studentDTO = studentRepository.findById(id);
        // 기존 정보 보여줌
        if(studentDTO == null)  {
            System.out.println("해당 정보가 없습니다");
        }
        else {
            System.out.print("수정할 전화번호:   ");
            String mobile = scanner.next();
            studentRepository.update(id, mobile);
        }
    }
   }