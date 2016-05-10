package model.tempest;

import model.AbstractPiece;
import model.Coord;

public class MovePionNoir extends MovePion{

	public MovePionNoir(Class<? extends AbstractPiece> type, Coord init) {
		super(type, init);
	}

	@Override
    protected boolean isVertiacalOk(int yFinal) {
        return yFinal - this.init.y > 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.init.y + 1) && (Math.abs(xFinal-this.init.x) == 1);
    }
	
	
}
