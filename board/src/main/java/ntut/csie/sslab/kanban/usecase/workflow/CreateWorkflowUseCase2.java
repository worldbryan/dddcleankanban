package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.DomainEventBus;

import java.util.UUID;

public class CreateWorkflowUseCase2 {
    private Workflow2Repository repository;
    DomainEventBus domainEventBus;

    public CreateWorkflowUseCase2(Workflow2Repository repository, 
                                  DomainEventBus domainEventBus) {
    
        this.repository = repository;
        this.domainEventBus = domainEventBus;
        
    }

    public void execute(CreateWorkflow2Input input, CreateWorkflow2Output output) {
        Workflow2 workflow2 = new Workflow2(
                input.getBoardId(),
                UUID.randomUUID().toString(),
                input.getWorkflowName()
        );

        repository.save(workflow2);
        domainEventBus.postAll(workflow2);
        output.setWorkflowId(workflow2.getId());
    }

}
