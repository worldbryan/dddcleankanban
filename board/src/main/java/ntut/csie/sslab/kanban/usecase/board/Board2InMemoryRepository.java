package ntut.csie.sslab.kanban.usecase.board;

import ntut.csie.sslab.ddd.usecase.AbstractRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Board2InMemoryRepository implements Board2Repository {
    private List<Board2> store = new ArrayList();

    @Override
    public List<Board2> findAll() {
        return Collections.unmodifiableList(store);
    }

    public Optional<Board2> findById(String boardId) {
        return store.stream()
                .filter(x -> x.getBoardId().equals(boardId))
                .findAny();
    }

    public void save(Board2 board) {
        store.add(board);
    }

    @Override
    public void deleteById(String s) {
        throw new RuntimeException("Unimplemented");
    }
}
