package respository;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    // 학생정보를 저장할 리스트
    private List<StudentDTO> studentDTOList = new ArrayList<>();

    public boolean save(StudentDTO studentDTO) {
        // id 값을 하나씩 증가시켜 함께 저장
        // (현재 리스트에 저장된 학생수 가져오고 1 증가하여 저장)
//        int size = studentDTOList.size();
//        studentDTO.setId((long) (size+1));
        //size는 개수를 의미함
        // 위방법은 삭제하고 등록 하면 번호가 증가하지 않아 문제가 있어 사용 안함

        // 리스트에 신규학생 추가
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public StudentDTO findById(long id) {

        for (StudentDTO studentDTO : studentDTOList) {
            if (id == studentDTO.getId()) {
                return studentDTO;
            }
        }
//        for(int i=0; i<studentDTOList.size();i++){
//            if (id ==  studentDTOList.get(i).getId()){
//                return studentDTOList.get(i);
//            }
//        }
        return null;
        // DTO에서 Long은 값이 null로 들어감(만약 long 이라면 0으로 들어감)
        // StudentDTO가 전체를 null로 사용 가능하므로 구성필드 타입이 어떤것으로 들어가도 관계없음
    }


    public boolean delete(long id) {
        boolean del = false;
//        for (StudentDTO studentDTO : studentDTOList) {
//            if (id == studentDTO.getId()) {
//                studentDTOList.remove(studentDTO); //객체를 불러(?) 삭제
//                del = true;
//            }
//        }
        //for-each는 수정 후 삭제하면 에러가 생김
        // 자바: java.util.ConcurrentModificationException 에러
        // 구글 검색을 해보니 List와 같은 객체를 for each 문을 돌릴 때, 해당 객체를 수정하면 발생한다고 한다.
        // 그리고 보통 해당상황이 발생하는 경우는 크게 두가지 경우가 있다고 한다.
        //싱글 스레드 환경에서 for each문 중간에 객체를 수정하는 경우
        //멀티 스레드 환경에서, 다른 스레드에서 객체 값이 수정된 경우.

        for(int i=0; i<studentDTOList.size(); i++){
            if (id ==  studentDTOList.get(i).getId()){
                studentDTOList.remove(i);  //인덱스에 해당하는 리스트를 삭제
                del= true;
            }
        }
        return del;
    }


    public void update(long id, String mobile) {
        for (StudentDTO studentDTO : studentDTOList) {
            if (id == studentDTO.getId()) {
                studentDTO.setStudentMobile(mobile);
                System.out.println("studentDTO = " + studentDTO);
            }
        }
    }
}
