package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<BoardDTO> boardDTOList = new ArrayList<>();

    //글작성
    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    //글조회
    public BoardDTO findById(long id) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (id == boardDTO.getId()) {
                return boardDTO;
            }
        }
        return null;
    }

    //검색
    public List<BoardDTO> search(String title) {
        List<BoardDTO> boardDTOList1 = new ArrayList<>();
        for (BoardDTO boardDTO : boardDTOList) {
            if (title.equals(boardDTO.getBoardTitle())) {
                boardDTOList1.add(boardDTO);
            }
        }
        if (boardDTOList1 != null) return boardDTOList1;
        else return null;
    }


    //글목록
    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    //수정
    public boolean update(Long id, String title, String contents) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (id == boardDTO.getId()) {
                boardDTO.setBoardTitle(title);
                boardDTO.setBoardContents(contents);
                return true;
            }
        }
        return false;
    }

    //삭제
    public void delete(Long id) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (id == boardDTO.getId()) {
                boardDTOList.remove(boardDTO);

            }
        }
    }
}
