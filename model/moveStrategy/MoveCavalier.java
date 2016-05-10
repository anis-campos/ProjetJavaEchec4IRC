package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveCavalier extends AbstractMoveStrategy {

	public MoveCavalier(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type, dep);
	}

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
		
		if ((Math.abs(xFinal - this.init.x) + Math.abs(yFinal - this.init.y)) == 3) {
			
			if ((Math.abs(xFinal - this.init.x)<3) && (Math.abs(yFinal - this.init.y)<3)) {
				ret  = true;
			}		
		}	
		return ret;
	}

}
