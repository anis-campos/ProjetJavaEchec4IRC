package model.moveStrategy;

import model.common.Deplacement;
import model.pieces.AbstractPiece;

public interface IMoveStrategyFactory {
	MoveStrategy create(Class<? extends AbstractPiece> type, Deplacement deplacement);
}
