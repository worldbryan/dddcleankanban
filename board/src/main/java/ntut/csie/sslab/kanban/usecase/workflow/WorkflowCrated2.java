package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.DomainEvent;
import ntut.csie.sslab.ddd.model.common.DateProvider;

import java.util.Date;

public class WorkflowCrated2 extends DomainEvent {

    private final String boardId;
    private final String workflowId;
    private final String name;

    public WorkflowCrated2(String boardId, String workflowId, String name) {
        super(DateProvider.now());
        this.boardId = boardId;
        this.workflowId = workflowId;
        this.name = name;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public String getName() {
        return name;
    }
}
