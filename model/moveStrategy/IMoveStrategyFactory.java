package model.moveStrategy;

import model.common.Deplacement;
import model.configuration.IFactory;
import model.pieces.AbstractPiece;

public interface IMoveStrategyFactory extends IFactory {
	IMoveStrategy create(Class<? extends AbstractPiece> type, Deplacement deplacement);
}
