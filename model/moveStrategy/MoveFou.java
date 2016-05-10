package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveFou extends AbstractMoveStrategy {

	public MoveFou(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type,dep);
	}

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
		
		if (Math.abs(yFinal - this.init.y) == Math.abs(xFinal - this.init.x)) {
			ret  = true;
		}		
		
		return ret;
	}

}
