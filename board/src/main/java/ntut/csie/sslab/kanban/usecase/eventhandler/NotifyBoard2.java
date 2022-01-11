package ntut.csie.sslab.kanban.usecase.eventhandler;

import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import ntut.csie.sslab.kanban.entity.model.board.Board;
import ntut.csie.sslab.kanban.usecase.board.Board2;
import ntut.csie.sslab.kanban.usecase.board.Board2Repository;
import ntut.csie.sslab.kanban.usecase.workflow.Workflow2Created;

public class NotifyBoard2 {

    private Board2Repository board2Repository;
    private DomainEventBus domainEventBus;

    public NotifyBoard2(Board2Repository board2Repository, DomainEventBus domainEventBus) {
        this.board2Repository = board2Repository;
        this.domainEventBus = domainEventBus;
    }

    @Subscribe
    public void whenWorkflow2Created(Workflow2Created event){

        Board2 board2 = board2Repository.findById(event.getBoardId()).get();

        board2.commitWorkflow(event.getWorkflowId());
        board2Repository.save(board2);
        domainEventBus.postAll(board2);
    }

//    public void whenBoardCreatedInTeam(TeamdEvents.BoardCreated event){
//
//        Board board = new Board(event)
//
//    }

}
