package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.AggregateRoot;
import ntut.csie.sslab.ddd.model.common.DateProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board2 extends AggregateRoot<String> {

    private final String teamId;
    private final String boardId;
    private String boardName;
    private final List<String> committedWorkflowIds;

    public Board2(String teamId, String boardId, String boardName) {
        super(boardId);
        this.teamId = teamId;
        this.boardId = boardId;
        this.boardName = boardName;
        committedWorkflowIds = new ArrayList<>();

        this.addDomainEvent(
                new Board2Created(teamId, boardId, boardId, DateProvider.now()));
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

    public void commitWorkflow(String workflowId) {
        committedWorkflowIds.add(workflowId);
        this.addDomainEvent(new CommittedWorkflow2(boardId, workflowId, DateProvider.now()));
    }

    public List<String> getCommittedWorkflows() {

        return Collections.unmodifiableList(committedWorkflowIds);
    }
}
