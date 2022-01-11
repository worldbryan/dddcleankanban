package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.DomainEvent;

import java.util.Date;

public class CommittedWorkflow2 extends DomainEvent {

    private final String boardId;
    private final String workflowId;


    public CommittedWorkflow2(String boardId, String workflowId, Date now) {
        super(now);
        this.boardId = boardId;
        this.workflowId = workflowId;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }
}
