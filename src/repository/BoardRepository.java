package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    Scanner scanner = new Scanner(System.in);
    List<BoardDTO>  boardDTOList = new ArrayList<>();
    int hits = 0;

    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public BoardDTO findById(long id) {

        for (BoardDTO boardDTO : boardDTOList) {
            if (id == boardDTO.getId()) {
                hits = hits + 1;
                boardDTO.setBoardHits(hits);
                return boardDTO;
            }
        }
        return null;
    }

    public MemberDTO login(String memberEmail, String memberPassword) {
        for (MemberDTO memberDTO: memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail()) && memberPassword.equals(memberDTO.getMemberPassword())) {
                return memberDTO;
            }
        }
        return null;
    }

    public boolean emailCheck(String memberEmail) {
        for (MemberDTO memberDTO: memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                // 일치하는 값이 있다는 것이므로 사용 불가능
                return false;
            }
        }
        // 일치하는 것을 못찾았으므로 사용 가능
        return true;
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public boolean update(Long id, String title, String contents) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (id == boardDTO.getId()) {
               boardDTO.setBoardTitle(title);
               boardDTO.setBoardContents(contents);
                return true;
            }
        }
        return false;
    }

    public void delete(String loginEmail) {
        for (MemberDTO memberDTO: memberDTOList) {
            if (loginEmail.equals(memberDTO.getMemberEmail())) {
                memberDTOList.remove(memberDTO);
            }
        }
    }
}
