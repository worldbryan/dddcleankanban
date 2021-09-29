package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.AggregateRoot;

public class Workflow2 extends AggregateRoot<String> {
    private String boardId;
    private String name;

    public Workflow2(String boardId, String workflowId, String name) {
        super(workflowId);
        this.boardId = boardId;
        this.name = name;

        addDomainEvent(new WorkflowCrated2(boardId, workflowId, name));
    }


}
