package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.AggregateRoot;
import ntut.csie.sslab.kanban.entity.model.board.CommittedWorkflow;
import ntut.csie.sslab.kanban.entity.model.board.event.WorkflowCommitted;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board2 extends AggregateRoot<String> {

    private String teamId;
    private String boardId;
    private String name;
    private List<CommittedWorkflow> committedWorkflows;

    public Board2(String teamId, String boardId, String name) {
        super(boardId);
        this.teamId = teamId;
        this.boardId = boardId;
        this.name = name;
        committedWorkflows = new ArrayList<>();

        addDomainEvent(new BoardCreated2(teamId, boardId, name));
    }

    public String getId() {
        return boardId;
    }

    public List<CommittedWorkflow> getCommittedWorkflows() {
        return Collections.unmodifiableList(committedWorkflows);
    }

    public void commitWorkflow(String workflowId) {
        CommittedWorkflow committedWorkflow = new CommittedWorkflow(
                this.boardId,
                workflowId,
                committedWorkflows.size());
        committedWorkflows.add(committedWorkflow);

        addDomainEvent(new WorkflowCommitted(this.boardId, workflowId));
    }
}
