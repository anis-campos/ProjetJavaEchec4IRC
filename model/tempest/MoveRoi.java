package model.tempest;

import model.AbstractPiece;
import model.Coord;

public class MoveRoi extends AbstractMoveStrategy{

	public MoveRoi(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal) {
		boolean ret = false;
		
		if ((Math.abs(yFinal - this.init.y) <= 1)
				&& (Math.abs(xFinal - this.init.x) <= 1)) {
			ret = true;
		}
		
		
		return ret;
	}
	
}
