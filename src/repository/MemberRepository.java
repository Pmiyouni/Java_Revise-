package repository;

import dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<MemberDTO> memberDTOList= new ArrayList<>();

    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public MemberDTO login(String mEmail, String mPassword){
        for (MemberDTO memberDTO : memberDTOList) {

            if (mEmail.equals(memberDTO.getMemberEmail()) && mPassword.equals(memberDTO.getMemberPassword())) {
                return memberDTO;
            }
        }
        return null;
    }

//
//    public List<MemberDTO> findAll() {
//        return memberDTOList;
//    }
//
//    public MemberDTO findById(String mEmail, String mPassword) {
//
//        for (MemberDTO memberDTO : memberDTOList) {
//            if (mEmail.equals(memberDTO.getMemberEmail()) && mPassword.equals(memberDTO.getMemberPassword())) {
//                return memberDTO;
//            }
//        }
//        return null;
//    }
//
//    public boolean emailCheck(String memberEmail) {
//        for (MemberDTO memberDTO: memberDTOList) {
//            if (memberEmail.equals(memberDTO.getMemberEmail())) {
//                // 일치하는 값이 있다는 것이므로 사용 불가능
//                return false;
//            }
//        }
//
//        // 일치하는 것을 못찾았으므로 사용 가능
//        return true;
//    }
//
//    public boolean delete(String lEmail, String mPassword) {
//        boolean del = false;
//        for(int i=0; i<memberDTOList.size(); i++){
//            if (lEmail.equals(memberDTOList.get(i).getMemberEmail()) && mPassword.equals(memberDTOList.get(i).getMemberPassword())){
//                memberDTOList.remove(i);
//                del= true;
//            }
//        }
//        return del;
//    }
//
//
//    public boolean update(String loginEmail, String updateMobile) {
//        for (MemberDTO memberDTO: memberDTOList) {
//            if (loginEmail.equals(memberDTO.getMemberEmail())) {
//                memberDTO.setMemberMobile(updateMobile);
//                return true;
//            }
//        }
//        return false;
//    }
//}
}
