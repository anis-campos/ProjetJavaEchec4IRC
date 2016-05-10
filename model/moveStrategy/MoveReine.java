package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveReine implements MoveStrategy {

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
	
	if (Math.abs(dep.cFinal.y - dep.cInit.y) == Math.abs(dep.cFinal.x - dep.cInit.x)
			|| ((dep.cFinal.y == dep.cInit.y) || (dep.cFinal.x == dep.cInit.x))) {
		ret =  true;
	}
	
	return ret;
	}

}
