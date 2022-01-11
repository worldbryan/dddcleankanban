package ntut.csie.sslab.kanban.usecase.workflow;

import ntut.csie.sslab.ddd.model.DomainEventBus;

public class CreateWorkflow2Usecase {
    private Workflow2Repository workflow2Repository;
    private DomainEventBus domainEventBus;

    public CreateWorkflow2Usecase(Workflow2Repository workflow2Repository, DomainEventBus domainEventBus) {
        this.workflow2Repository = workflow2Repository;
        this.domainEventBus = domainEventBus;
    }

    public void execute(CreateWorkflow2Input input, CreateWorkflow2Output output) {
        Workflow2 workflow2 = new Workflow2(input.getBoardId(),
                input.getWorkflowId(),
                input.getWorkflowName());
        workflow2Repository.save(workflow2);
        domainEventBus.postAll(workflow2);
        output.setWorkflowId(workflow2.getId());
    }
}
