package model.tempest;

import model.AbstractPiece;

public class MoveRoi extends AbstractMoveStrategy{

	public MoveRoi(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type, dep);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal, boolean isCatchOk,
            boolean isCastlingPossible) {
		boolean ret = false;
		
		if ((Math.abs(yFinal - this.init.y) <= 1)
				&& (Math.abs(xFinal - this.init.x) <= 1)) {
			ret = true;
		}
		
		
		return ret;
	}
	
}
