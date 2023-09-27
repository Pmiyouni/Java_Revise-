package dto;

public class StudentDTO {
    private Long id; // 학생 관리번호,
    private String studentName;
    private String studentMajor;

    private String studentMobile;

    // 증가값을 유지하기 위해 static으로 선언(static는 메모리에 올라가서 계속 유지함)
    private static long num = 1L; //초기값이 1이고 계속유지하며 증가함

    // 기본생성자
    public StudentDTO() {
    }

    public StudentDTO(String studentName, String studentMajor, String studentMobile) {
        //객체를 생성하면서 num 값을 하나 증가시킨 결과를 id에 저장
        // 생성자를 호출하면 new가 되나 static 변수는 그대로 유지됨
        this.id = num++;
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentMobile = studentMobile;
    }

    // getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    // toString
    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                '}';
    }
}