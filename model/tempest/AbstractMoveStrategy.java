package model.tempest;

import model.AbstractPiece;
import model.Coord;

public abstract class AbstractMoveStrategy implements MoveStrategy{
	Coord init;
	Class<? extends AbstractPiece> type;
	
	public AbstractMoveStrategy(Class<? extends AbstractPiece> type, Coord init) {
		this.type = type;
		this.init = init;
	}
	
    public final boolean isMoveOkTempest(int xFinal, int yFinal){
		return false;
    }
}
