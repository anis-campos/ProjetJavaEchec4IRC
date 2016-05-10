package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveTour extends AbstractMoveStrategy {

	public MoveTour(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type, dep);
	}

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
		
		if ((yFinal == init.y) || (xFinal == init.x)) {
			ret = true;
		}
		
		return ret;
	}

}
