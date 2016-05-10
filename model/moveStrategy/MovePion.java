package model.moveStrategy;

import model.pieces.AbstractPiece;

public abstract class MovePion implements MoveStrategy {


	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;

        // Déplacement vertical
        if (!dep.isCatchOk && !dep.isCastlingPossible) {

            if ((dep.cFinal.x == dep.cInit.x)
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
