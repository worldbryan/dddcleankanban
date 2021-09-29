package ntut.csie.sslab.kanban.usecase.eventhandler;

import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import ntut.csie.sslab.kanban.usecase.board.Board2;
import ntut.csie.sslab.kanban.usecase.board.Board2Repository;
import ntut.csie.sslab.kanban.usecase.workflow.WorkflowCrated2;

public class NotifyBoard2 {

    private Board2Repository boardRepository;
    private DomainEventBus domainEventBus;

    public NotifyBoard2(Board2Repository boardRepository,
                        DomainEventBus domainEventBus) {
        this.boardRepository = boardRepository;
        this.domainEventBus = domainEventBus;
    }

    @Subscribe
    public void whenWorkflowCreated(WorkflowCrated2 event){
        Board2 board2 = boardRepository.findById(event.getBoardId()).get();
        board2.commitWorkflow(event.getWorkflowId());
        boardRepository.save(board2);
        domainEventBus.postAll(board2);
    }

}
