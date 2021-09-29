package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.DomainEventBus;

import java.util.UUID;

public class CreateBoardUseCase2 {

    private Board2Repository repository;
    private DomainEventBus domainEventBus;

    public CreateBoardUseCase2(Board2Repository repository,
                               DomainEventBus domainEventBus) {
        this.repository = repository;
        this.domainEventBus = domainEventBus;
    }

    public void execute(CreateBoardInput2 input,
                        CreateBoardOutput2 output) {

        Board2 board2 = new Board2(input.getTeamId(),
                UUID.randomUUID().toString(),
                input.getName());

        repository.save(board2);
        domainEventBus.postAll(board2);

        output.setBoardId(board2.getId());

    }
}
