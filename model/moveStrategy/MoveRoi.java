package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveRoi implements MoveStrategy {

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
		
		if ((Math.abs(dep.cFinal.y - dep.cInit.y) <= 1)
				&& (Math.abs(dep.cFinal.x - dep.cInit.x) <= 1)) {
			ret = true;
		}
		
		
		return ret;
	}
	
}
