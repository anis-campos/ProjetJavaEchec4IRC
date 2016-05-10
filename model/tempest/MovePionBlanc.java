package model.tempest;

import model.AbstractPiece;

public class MovePionBlanc extends MovePion{

	public MovePionBlanc(Class<? extends AbstractPiece> type, Deplacement dep) {
		super(type, dep);
	}

    @Override
    protected boolean isVertiacalOk(int yFinal) {
        return yFinal - this.init.y < 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.init.y - 1) && (Math.abs(xFinal-this.init.x) == 1);
    }

}
