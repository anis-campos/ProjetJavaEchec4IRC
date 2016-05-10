package model.tempest;

import model.AbstractPiece;
import model.Coord;

public abstract class AbstractMoveStrategy implements MoveStrategy{
	private final Boolean premierCoup;
	Coord init;
	Class<? extends AbstractPiece> type;
	
	public AbstractMoveStrategy(Class<? extends AbstractPiece> type, Deplacement deplacement) {
		this.type = type;
		this.init = deplacement.init;
		this.premierCoup = deplacement.premierCoup;
	}
	
    public final boolean isMoveOkTempest(int xFinal, int yFinal){
		return false;
    }
}
