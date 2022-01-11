package ntut.csie.sslab.kanban.entity.model.board;

import ntut.csie.sslab.kanban.usecase.board.Board2;
import ntut.csie.sslab.kanban.usecase.board.Board2Created;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Board2Test {

    @Test
    public void creating_a_board_generates_a_board_created_domain_event(){

        Board2 board2 = new Board2(
                "tead id",
                "board id",
                "board name");

        assertEquals(1, board2.getDomainEvents().size());
        assertEquals(Board2Created.class, board2.getDomainEvents().get(0).getClass());


    }

}
