package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.DomainEvent;

import java.util.Date;

public class Workflow2Created extends DomainEvent {

    private final String boardId;
    private final String workflowId;
    private final String workflowName;

    public Workflow2Created(String boardId, String workflowId, String workflowName, Date occurredOn) {

        super(occurredOn);
        this.boardId = boardId;
        this.workflowId = workflowId;
        this.workflowName = workflowName;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getWorkflowName() {
        return workflowName;
    }
}
