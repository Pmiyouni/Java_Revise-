package service;

import dto.BoardDTO;
import repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    //글 작성
    public void save() {
        System.out.print("제목: ");
        String boardTitle = scanner.next();
        System.out.print("작성자: ");
        String boardWriter = scanner.next();
        System.out.print("내용: ");
        String boardContents = scanner.next();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();

        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boolean result = boardRepository.save(boardDTO);
        if (result) {
            System.out.println("글쓰기 완료");
        } else {
            System.out.println("글쓰기 실패");
        }
    }

    //글조회
    public void findById() {
        System.out.print("조회할 id: ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        //System.out.println(boardDTO.toString());
        if (boardDTO != null) {
            boardDTO.setBoardHits(boardDTO.getBoardHits() + 1);
            System.out.println("글번호 : " + boardDTO.getId());
            System.out.println("제목 : " + boardDTO.getBoardTitle());
            System.out.println("작성자 : " + boardDTO.getBoardWriter());
            System.out.println("조회수 : " + boardDTO.getBoardHits() + " 회");
            System.out.println("내용 : " + boardDTO.getBoardContents());
        } else {
            System.out.println("찾는 글이 없습니다");
        }
    }

    //글목록
    public void findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        for (BoardDTO boardDTO : boardDTOList) {
            //System.out.println(boardDTO.toString());
            System.out.println("글번호 : " + boardDTO.getId());
            System.out.println("제목 : " + boardDTO.getBoardTitle());
            System.out.println("작성자 : " + boardDTO.getBoardWriter());
            System.out.println("조회수 : " + boardDTO.getBoardHits());
            System.out.println("-------------------------------");
        }
    }

    //글수정
    public void update() {
        System.out.print("수정할 id 입력:  ");
        Long id = scanner.nextLong();
        System.out.print("비밀번호 입력:  ");
        String password = scanner.next();

        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            if (password.equals(boardDTO.getBoardPass())) {
                System.out.print("수정할 제목 입력:   ");
                String title = scanner.next();
                System.out.print("수정할 내용 입력:   ");
                String contents = scanner.next();
                boolean result = boardRepository.update(id, title, contents);
                if (result) {
                    System.out.println("수정 완료");
                } else {
                    System.out.println("수정 실패");
                }
            } else {
                System.out.println("비밀번호 오류");
            }
        } else {
            System.out.println("해당 내용이 없습니다");
        }
    }

    //검색
    public void search() {
        System.out.print("검색할 제목 입력:  ");
        String title = scanner.next();

        List<BoardDTO> boardDTOList1 = boardRepository.search(title);
        if (boardDTOList1 != null) {
            for (BoardDTO boardDTO : boardDTOList1) {
                System.out.println("글번호 : " + boardDTO.getId() + "   작성자 : " + boardDTO.getBoardWriter());
                System.out.println(boardDTO.getBoardContents());
                System.out.println("==============================");
            }
        } else {
            System.out.println("해당 내용이 없습니다");
        }
    }


    //글삭제
    public void delete() {
        System.out.print("삭제할 id 입력:  ");
        Long id = scanner.nextLong();
        System.out.print("비밀번호 입력:  ");
        String password = scanner.next();

        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            if (password.equals(boardDTO.getBoardPass())) {
                boardRepository.delete(id);
                System.out.println("삭제 완료");
            } else {
                System.out.println("비밀번호 오류");
            }
        } else {
            System.out.println("해당 정보가 없습니다");
        }
    }
}

