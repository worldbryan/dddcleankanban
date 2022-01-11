package ntut.csie.sslab.kanban.usecase.workflow;

import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import ntut.csie.sslab.kanban.usecase.workflow.create.CreateWorkflowUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateWorkflow2UsecaseTest {
    @Test
    public void createWorkflow(){
        Workflow2Repository workflow2Repository =
                new Workflow2InMemoryRepository();
        DomainEventBus domainEventBus = new GoogleEventBus();
        FakeListener fakeListener = new FakeListener();
        domainEventBus.register(fakeListener);
        CreateWorkflow2Usecase createWorkflow2Usecase =
                new CreateWorkflow2Usecase(workflow2Repository, domainEventBus);

        CreateWorkflow2Input input = new CreateWorkflow2Input();
        input.setBoardId("board id");
        input.setWorkflowId("work id");
        input.setWorkflowName("name");
        CreateWorkflow2Output output = new CreateWorkflow2Output();

        createWorkflow2Usecase.execute(input, output);

        assertEquals(input.getWorkflowId(), output.getWorkflowId());
        assertNotNull(workflow2Repository.findById(input.getWorkflowId()).get());
        assertEquals(1, fakeListener.count);
    }

    class FakeListener {
        public int count = 0;
        @Subscribe
        public void whenWork2Created(Workflow2Created event){
            count++;
        }
    }
}
