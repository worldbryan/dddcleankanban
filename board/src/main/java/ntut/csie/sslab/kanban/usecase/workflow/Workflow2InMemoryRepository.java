package ntut.csie.sslab.kanban.usecase.workflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Workflow2InMemoryRepository implements Workflow2Repository {
    List<Workflow2> list = new ArrayList<>();
    @Override
    public List<Workflow2> findAll() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public Optional<Workflow2> findById(String s) {
        return list.stream().filter(x -> x.getId().equals(s)).findAny();
    }

    @Override
    public void save(Workflow2 data) {
        list.add(data);
    }

    @Override
    public void deleteById(String s) {

    }
}
