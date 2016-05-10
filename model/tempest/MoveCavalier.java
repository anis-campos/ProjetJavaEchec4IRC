package model.tempest;

import model.AbstractPiece;
import model.Coord;

public class MoveCavalier extends AbstractMoveStrategy{

	public MoveCavalier(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal) {
		boolean ret = false;
		
		if ((Math.abs(xFinal - this.init.x) + Math.abs(yFinal - this.init.y)) == 3) {
			
			if ((Math.abs(xFinal - this.init.x)<3) && (Math.abs(yFinal - this.init.y)<3)) {
				ret  = true;
			}		
		}	
		return false;
	}

}
