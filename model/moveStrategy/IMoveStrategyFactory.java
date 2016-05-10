package model.moveStrategy;

import model.pieces.AbstractPiece;

public interface IMoveStrategyFactory {
	public MoveStrategy create(Class<? extends AbstractPiece> type);
}
