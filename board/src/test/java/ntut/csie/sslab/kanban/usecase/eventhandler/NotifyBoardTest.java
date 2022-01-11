package ntut.csie.sslab.kanban.usecase.eventhandler;

import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import ntut.csie.sslab.kanban.usecase.board.*;
import ntut.csie.sslab.kanban.usecase.workflow.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotifyBoardTest {

        DomainEventBus domainEventBus = new GoogleEventBus();
        Board2Repository board2Repository = new Board2InMemoryRepository();
        Workflow2Repository workflow2Repository =
                new Workflow2InMemoryRepository();

        @Test
        public void creating_a_workflow_commits_itself_to_its_board(){
            NotifyBoard2 notifyBoard2 = new NotifyBoard2(board2Repository, domainEventBus);
            domainEventBus.register(notifyBoard2);
            String boardId = createBoard2();
            String worflowId = crateWorkflow(boardId);

            Board2 board2 = board2Repository.findById(boardId).get();
            assertEquals(1, board2.getCommittedWorkflows().size());
     }


    private String createBoard2(){
        CreateBoardUseCase2 createBoardUseCase2 =
                new CreateBoardUseCase2(board2Repository, domainEventBus);
        CreateBoardInput2 input = new CreateBoardInput2();
        input.setTeamId("team id");
        input.setBoardId(UUID.randomUUID().toString());
        input.setBoardName("Scrum Board");
        CreateBoardOutput2 output = new CreateBoardOutput2();

        createBoardUseCase2.execute(input, output);
        return output.getBoardId();
    }

    private String crateWorkflow(String boardId){
        CreateWorkflow2Usecase createWorkflow2Usecase =
                new CreateWorkflow2Usecase(workflow2Repository, domainEventBus);

        CreateWorkflow2Input input = new CreateWorkflow2Input();
        input.setBoardId(boardId);
        input.setWorkflowId("workflow id");
        input.setWorkflowName("name");
        CreateWorkflow2Output output = new CreateWorkflow2Output();

        createWorkflow2Usecase.execute(input, output);
        return output.getWorkflowId();
    }
}
