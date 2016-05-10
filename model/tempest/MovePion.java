package model.tempest;

import model.AbstractPiece;
import model.Coord;

public abstract class MovePion extends AbstractMoveStrategy {

	public MovePion(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
	}

	@Override
	public boolean isMoveOkStandard(int xFinal, int yFinal, boolean isCatchOk,
            boolean isCastlingPossible) {
		boolean ret = false;

        // Déplacement vertical
        if (!isCatchOk && !isCastlingPossible) {

            if ((xFinal == this.init.x)
                    && (Math.abs(yFinal - this.init.y) <= 1 ||
                    (Math.abs(yFinal - this.init.y) <= 2 && this.premierCoup == true))) {

                ret = isVertiacalOk(yFinal);
            }
        }
        // Déplacement diagonal
        else {
            ret = isDiagonalOk(xFinal, yFinal);
        }

        return ret;
        
	}


    protected abstract boolean isVertiacalOk(int yFinal);

    protected abstract boolean isDiagonalOk(int xFinal, int yFinal);


}
