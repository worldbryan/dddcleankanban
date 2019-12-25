package tw.teddysoft.clean.domain.model.kanbanboard.home;

import tw.teddysoft.clean.domain.model.Entity;
import tw.teddysoft.clean.domain.model.kanbanboard.home.event.HomeCreated;
import tw.teddysoft.clean.domain.model.kanbanboard.workspace.CommittedBoard;
import tw.teddysoft.clean.domain.model.kanbanboard.workspace.event.BoardCommitted;
import tw.teddysoft.clean.domain.model.kanbanboard.workspace.event.WorkspaceCreated;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Home extends Entity {

    private String userId;
    private Set<CommittedBoard> committedBoards;

    public Home(String name, String userId) {
        super(name);
        this.userId = userId;
        committedBoards = new HashSet<>();

        addDomainEvent(new HomeCreated(this.getId(), userId, name));
    }

//    public void commitBoard(String boardId){
//        CommittedBoard committedBoard = new CommittedBoard(this.getId(), boardId);
//        committedBoard.setOrdering(committedBoards.size() + 1);
//        committedBoards.add(committedBoard);
//
//        addDomainEvent(new BoardCommitted(this));
//    }
//
//    public Set<CommittedBoard> getCommittedBoards() {
//        return Collections.unmodifiableSet(committedBoards);
//    }
//
//    public int getBoardOrderingById(String boardId){
//        for (CommittedBoard each : committedBoards){
//            if (each.getBoardId().equalsIgnoreCase(boardId)){
//                return each.getOrdering();
//            }
//        }
//        return 0;
//    }
//
//    public void reorderBoards(String boardId, int oldOrdering, int newOrdering) {
//        if(isMoveToSameOrdering(newOrdering, oldOrdering))
//            return;
//
//        for(CommittedBoard each : committedBoards){
//            if(each.getOrdering() == oldOrdering){
//                each.setOrdering(newOrdering);
//                continue;
//            }
//            if (isMoveForward(newOrdering, oldOrdering)){
//                if (inForwardFreeZone(newOrdering, oldOrdering, each))
//                    continue;
//                if(inForwardAffectedZone(newOrdering, oldOrdering, each))
//                    each.moveBackward();
//            }else {
//                // move backward
//                if (inBackwardFreeZone(newOrdering, oldOrdering, each)){
//                    continue;
//                }
//                if(inBackwardAffectedZone(newOrdering, oldOrdering, each)){
//                    each.moveForward();
//                }
//            }
//        }
//    }
//
//
//    private boolean inForwardAffectedZone(int newOrdering, int oldOrdering, CommittedBoard each){
//        return each.getOrdering() >= newOrdering && each.getOrdering() < oldOrdering;
//    }
//
//    private boolean inBackwardAffectedZone(int newOrdering, int oldOrdering, CommittedBoard each){
//        return each.getOrdering() > oldOrdering && each.getOrdering() <= newOrdering;
//    }
//
//
//    private boolean inForwardFreeZone(int newOrdering, int oldOrdering, CommittedBoard each) {
//        return each.getOrdering() < newOrdering || each.getOrdering() > oldOrdering;
//    }
//
//    private boolean inBackwardFreeZone(int newOrdering, int oldOrdering, CommittedBoard each){
//        return (each.getOrdering() < oldOrdering || each.getOrdering() > newOrdering);
//    }
//
//    private boolean isMoveToSameOrdering(int newOrdering, int oldOrdering) {
//        return newOrdering == oldOrdering;
//    }
//
//    private boolean isMoveForward(int newOrdering, int oldOrdering){
//        return newOrdering < oldOrdering ? true : false;
//    }
//
//    public String dump() {
//        StringBuilder sb = new StringBuilder();
//        for (CommittedBoard each : committedBoards) {
//            sb.append("board");
//            sb.append(String.format("[ordering]=%-16s", each.getOrdering()));
//                sb.append(String.format("[board id]=%-40s", each.getBoardId()));
////                sb.append(String.format("[board id]=%-40s", each.getBoardId()));
//                sb.append("\n");
//        }
//
//        System.out.println("Dump Committed Boards => \n" + sb.toString());
//
//        return sb.toString();
//    }

    public String getUserId() {
        return userId;
    }
}