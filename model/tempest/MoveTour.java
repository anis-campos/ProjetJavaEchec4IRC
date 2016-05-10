package model.tempest;

import model.AbstractPiece;
import model.Coord;

public class MoveTour extends AbstractMoveStrategy{

	public MoveTour(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal, boolean isCatchOk,
            boolean isCastlingPossible) {
		boolean ret = false;
		
		if ((yFinal == init.y) || (xFinal == init.x)) {
			ret = true;
		}
		
		return ret;
	}

}
