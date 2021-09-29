package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.DomainEvent;
import ntut.csie.sslab.ddd.model.common.DateProvider;

public class BoardCreated2 extends DomainEvent {

    private final String teamId;
    private final String boardId;
    private final String name;

    public BoardCreated2(String teamId, String boardId, String name) {
        super(DateProvider.now());
        this.teamId = teamId;
        this.boardId = boardId;
        this.name = name;
    }

}
