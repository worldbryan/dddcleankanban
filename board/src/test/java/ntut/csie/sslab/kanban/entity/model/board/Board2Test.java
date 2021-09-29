package ntut.csie.sslab.kanban.entity.model.board;

import ntut.csie.sslab.kanban.usecase.board.Board2;
import ntut.csie.sslab.kanban.usecase.board.BoardCreated2;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Board2Test {

    @Test
    public void create_a_board_generates_a_board_created_domain_event(){

        Board2 board2 = new Board2("teamid", "boardid", "boardname");


        assertEquals(1, board2.getDomainEvents().size());
        assertEquals(BoardCreated2.class, board2.getDomainEvents().get(0).getClass());


    }


}
