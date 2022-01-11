package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.DomainEvent;

import java.util.Date;

public class Board2Created extends DomainEvent {

    private final String teamId;
    private final String boardId;
    private final String boardName;

    public Board2Created(String teamId, String boardId, String boardName, Date occurredOn) {
        super(occurredOn);
        this.teamId = teamId;
        this.boardId = boardId;
        this.boardName = boardName;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }
}
