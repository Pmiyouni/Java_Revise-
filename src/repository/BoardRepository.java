package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    List<BoardDTO>  boardDTOList = new ArrayList<>();


    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public BoardDTO findById(long id) {

        for (BoardDTO boardDTO : boardDTOList) {
            if (id == boardDTO.getId()) {
                return boardDTO;
            }
        }
        return null;
    }

    public List<BoardDTO> search(String title) {
        List<BoardDTO> boardDTOList1 = new ArrayList<>();
        for (BoardDTO boardDTO: boardDTOList) {
            if (title.equals(boardDTO.getBoardTitle())) {
                boardDTOList1.add(boardDTO);
            }
        }
        if(boardDTOList1 != null) return  boardDTOList1;
            else return null;
    }



    public List<BoardDTO> findAll() {
        return boardDTOList;
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

    public boolean delete(Long id) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (id == boardDTO.getId()) {
                boardDTOList.remove(boardDTO);
                return true;
            }
        }
        return false;
    }
}

