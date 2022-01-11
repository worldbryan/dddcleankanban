package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.AggregateRoot;
import ntut.csie.sslab.ddd.model.common.DateProvider;

public class Workflow2 extends AggregateRoot<String> {
    private String boardId;
    private String workflowId;
    private String workflowName;

    public Workflow2(String boardId, String workflowId, String workflowName) {
        super(workflowId);
        this.boardId = boardId;
        this.workflowId = workflowId;
        this.workflowName = workflowName;
        this.addDomainEvent(
            new Workflow2Created(boardId, workflowId, workflowName, DateProvider.now())
        );
    }
}
