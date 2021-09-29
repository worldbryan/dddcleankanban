package ntut.csie.sslab.kanban.usecase.workflow;

import java.util.ArrayList;
import java.util.List;

public class Workflow2Repository {
    List<Workflow2> workflow2s = new ArrayList<>();

    public void save(Workflow2 workflow2) {
        workflow2s.add(workflow2);
    }
}
