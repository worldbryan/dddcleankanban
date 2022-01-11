package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.model.DomainEventBus;

public class CreateBoardUseCase2 {
    private final Board2Repository board2InMemoryRepository;
    private final DomainEventBus domainEventBus;

    public CreateBoardUseCase2(
            Board2Repository board2InMemoryRepository,
            DomainEventBus domainEventBus) {

        this.board2InMemoryRepository = board2InMemoryRepository;
        this.domainEventBus = domainEventBus;
    }

    public void execute(CreateBoardInput2 input,
                        CreateBoardOutput2 output) {

        Board2 board = new Board2(
                input.getTeamId(),
                input.getBoardId(),
                input.getBoardName());

        board2InMemoryRepository.save(board);
        domainEventBus.postAll(board);

        output.setBoardId(board.getBoardId());

    }
}
