package tw.teddysoft.clean.domain.model.kanbanboard.old_stage.event;

import tw.teddysoft.clean.domain.model.AbstractDomainEvent;

public class MiniStageDeleted extends AbstractDomainEvent {

    public MiniStageDeleted(String id, String name) {
        super(id, name);
    }
}