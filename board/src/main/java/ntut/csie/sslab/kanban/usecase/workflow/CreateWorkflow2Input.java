package ntut.csie.sslab.kanban.usecase.workflow;

public class CreateWorkflow2Input {
    private String boardId;
    private String workflowName;

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }
}
