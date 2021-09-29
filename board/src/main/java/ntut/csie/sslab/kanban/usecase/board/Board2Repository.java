package ntut.csie.sslab.kanban.usecase.board;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board2Repository {
    private List<Board2> boards = new ArrayList<>();

    public Optional<Board2> findById(String boardId) {
            return boards.stream().
                    filter( x-> x.getId().equals(boardId)).
                    findAny();
    }

    public void save(Board2 board2) {
        boards.add(board2);
    }
}
