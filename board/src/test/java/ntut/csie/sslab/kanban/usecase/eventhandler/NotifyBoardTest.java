package ntut.csie.sslab.kanban.usecase.eventhandler;

import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import ntut.csie.sslab.kanban.usecase.board.*;
import ntut.csie.sslab.kanban.usecase.workflow.CreateWorkflow2Input;
import ntut.csie.sslab.kanban.usecase.workflow.CreateWorkflow2Output;
import ntut.csie.sslab.kanban.usecase.workflow.CreateWorkflowUseCase2;
import ntut.csie.sslab.kanban.usecase.workflow.Workflow2Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotifyBoardTest {

    private Board2Repository boardRepository;
    private  DomainEventBus domainEventBus;
    private Workflow2Repository workflow2Repository;

    @Test
    public void create_a_workflow_commits_itself_to_its_board() throws InterruptedException {

        boardRepository = new Board2Repository();
        domainEventBus = new GoogleEventBus();
        workflow2Repository = new Workflow2Repository();

        NotifyBoard2 notifyBoard = new NotifyBoard2(boardRepository, domainEventBus);
        domainEventBus.register(notifyBoard);
        String boardId = createBoard();
        Board2 board2 = boardRepository.findById(boardId).get();
        assertEquals(0, board2.getCommittedWorkflows().size());

        String workflowId = crateWorkflow(boardId);

        board2 = boardRepository.findById(boardId).get();
        assertEquals(1, board2.getCommittedWorkflows().size());

    }

    public String createBoard(){

        CreateBoardUseCase2 createBoardUseCase2 =
                new CreateBoardUseCase2(boardRepository, domainEventBus);

        CreateBoardInput2 createBoardInput2 = new CreateBoardInput2();
        createBoardInput2.setTeamId("team001");
        createBoardInput2.setName("Kanban board");
        CreateBoardOutput2 createBoardOutput2 = new CreateBoardOutput2();

        createBoardUseCase2.execute(createBoardInput2, createBoardOutput2);

        return createBoardOutput2.getBoardId();
    }

    private String crateWorkflow(String boardId){

        CreateWorkflowUseCase2 createWorkflowUseCase2 =
                new CreateWorkflowUseCase2(workflow2Repository, domainEventBus);
        CreateWorkflow2Input input = new CreateWorkflow2Input();
        input.setBoardId(boardId);
        input.setWorkflowName("workflow name");
        CreateWorkflow2Output output = new CreateWorkflow2Output();

        createWorkflowUseCase2.execute(input, output);
        return output.getWorkflowId();
    }



}
