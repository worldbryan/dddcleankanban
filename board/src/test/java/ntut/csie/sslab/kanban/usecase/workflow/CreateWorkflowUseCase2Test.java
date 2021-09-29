package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateWorkflowUseCase2Test {

    @Test
    public void create_a_normal_workflow(){

        Workflow2Repository repository = new Workflow2Repository();
        DomainEventBus domainEventBus = new GoogleEventBus();
        CreateWorkflowUseCase2 createWorkflowUseCase2 =
                new CreateWorkflowUseCase2(repository, domainEventBus);
        CreateWorkflow2Input input = new CreateWorkflow2Input();
        input.setBoardId("boardId");
        input.setWorkflowName("workflow name");
        CreateWorkflow2Output output = new CreateWorkflow2Output();

      createWorkflowUseCase2.execute(input, output);

        assertNotNull(output.getWorkflowId());


    }




}
