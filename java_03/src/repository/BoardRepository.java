package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    Scanner scanner = new Scanner(System.in);
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

    //조회수 증가
    public boolean boardHits(long findID){
        for(BoardDTO boardDTO : boardDTOList){
            if(findID == boardDTO.getId()){
                int hits = boardDTO.getBoardHits();
                hits = hits + 1;
                boardDTO.setBoardHits(hits);
                // boardDTO.setBoardHits(boardDTO.getBoardHits() + 1);
                return true;
            }
        }
        return false;
    }

    //검색
    public List<BoardDTO> search(String title) {

        List<BoardDTO> searchList = new ArrayList<>();
        for (BoardDTO boardDTO : boardDTOList) {
            if (title.equals(boardDTO.getBoardTitle())) {
                searchList.add(boardDTO);
            }
        }
        return searchList;
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
            if (id.equals(boardDTO.getId())) {
                boardDTOList.remove(boardDTO);

            }
        }
    }
}
