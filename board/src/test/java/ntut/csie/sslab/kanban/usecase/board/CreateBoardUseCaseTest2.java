package ntut.csie.sslab.kanban.usecase.board;

import com.google.common.eventbus.Subscribe;
import ntut.csie.sslab.ddd.adapter.gateway.GoogleEventBus;
import ntut.csie.sslab.ddd.model.DomainEventBus;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateBoardUseCaseTest2 {

    @Test
    public void create_board(){

        DomainEventBus domainEventBus = new GoogleEventBus();
        FakeLisenter fakeLisenter = new FakeLisenter();
        domainEventBus.register(fakeLisenter);

        Board2Repository board2InMemoryRepository = new Board2InMemoryRepository();
        CreateBoardUseCase2 createBoardUseCase2 =
                new CreateBoardUseCase2(board2InMemoryRepository, domainEventBus);
        CreateBoardInput2 input = new CreateBoardInput2();
        input.setTeamId("team id");
        input.setBoardId(UUID.randomUUID().toString());
        input.setBoardName("Scrum Board");
        CreateBoardOutput2 output = new CreateBoardOutput2();

        createBoardUseCase2.execute(input, output);

        assertNotNull(output.getBoardId());
        assertNotNull(board2InMemoryRepository.findById(output.getBoardId()).get());
        assertEquals(1, fakeLisenter.notifyCount);

    }

    public class FakeLisenter{
        public int notifyCount = 0;

        @Subscribe
        public void whenBoardCreated(Board2Created event){
            notifyCount++;
        }
    }



}
