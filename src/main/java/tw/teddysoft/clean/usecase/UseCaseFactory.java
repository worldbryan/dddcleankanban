package tw.teddysoft.clean.usecase;

import tw.teddysoft.clean.domain.usecase.UseCase;
import tw.teddysoft.clean.usecase.kanbanboard.board.create.impl.CreateBoardUseCaseImpl;
import tw.teddysoft.clean.usecase.kanbanboard.workspace.WorkspaceRepository;
import tw.teddysoft.clean.usecase.kanbanboard.workspace.create.CreateWorkspaceOutput;
import tw.teddysoft.clean.usecase.kanbanboard.workspace.create.CreateWorkspaceUseCase;
import tw.teddysoft.clean.usecase.kanbanboard.workspace.create.impl.CreateWorkspaceUseCaseImpl;

public class UseCaseFactory {

    public static UseCase newCreateWorkspaceUseCase(WorkspaceRepository repository){
        return new CreateWorkspaceUseCaseImpl(repository);
    }


}