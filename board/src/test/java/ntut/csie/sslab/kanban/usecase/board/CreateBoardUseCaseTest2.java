package ntut.csie.sslab.kanban.usecase.board;

import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBoardUseCaseTest2 {

    @Test
    public void create_a_normal_board(){
        Notify notify = new Notify();
        Board2Repository repository = new Board2Repository();
        DomainEventBus domainEventBus = new GoogleEventBus();
        domainEventBus.register(notify);
        CreateBoardUseCase2 createBoardUseCase2 =
                new CreateBoardUseCase2(repository, domainEventBus);

        CreateBoardInput2 createBoardInput2 = new CreateBoardInput2();
        createBoardInput2.setTeamId("team001");
        createBoardInput2.setName("Kanban board");
        CreateBoardOutput2 createBoardOutput2 = new CreateBoardOutput2();

        createBoardUseCase2.execute(createBoardInput2, createBoardOutput2);

        assertNotNull(createBoardOutput2.getBoardId());
        assertTrue(repository.findById(
                createBoardOutput2.getBoardId()).isPresent());

        assertEquals(1, notify.notifyCount);

    }

    public class Notify{
        public int notifyCount = 0;

        @Subscribe
        public void whenBoardCreated(BoardCreated2 event){
            notifyCount++;
        }
    }


}
