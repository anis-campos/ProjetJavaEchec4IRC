package model.tempest;

import model.AbstractPiece;

public class MoveReine extends AbstractMoveStrategy {

	public MoveReine(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type, dep);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal, boolean isCatchOk,
            boolean isCastlingPossible) {
		boolean ret = false;
	
	if (Math.abs(yFinal - this.init.y) == Math.abs(xFinal - this.init.x)
			|| ((yFinal == this.init.y) || (xFinal == this.init.x))) {
		ret =  true;
	}
	
	return ret;
	}

}
