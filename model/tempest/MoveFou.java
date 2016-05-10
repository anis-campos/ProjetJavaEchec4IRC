package model.tempest;

import model.AbstractPiece;
import model.Coord;

public class MoveFou extends AbstractMoveStrategy{

	public MoveFou(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal, boolean isCatchOk,
            boolean isCastlingPossible) {
		boolean ret = false;
		
		if (Math.abs(yFinal - this.init.y) == Math.abs(xFinal - this.init.x)) {
			ret  = true;
		}		
		
		return ret;
	}

}
