package model.moveStrategy;

import model.common.Deplacement;

public class MovePionBlanc extends MovePion {

	private static MovePionBlanc instance;
	
	private MovePionBlanc() {
	}
	
	public static MovePionBlanc getInstance(){
		if (instance == null) {
            instance = new MovePionBlanc();
        }

        return instance;
	}
	
    @Override
    protected boolean isVerticalOk(Deplacement dep) {
        return dep.cFinal.y - dep.cInit.y < 0;
    }

    @Override
    protected boolean isDiagonalOk(Deplacement dep) {
        return (dep.cFinal.y == dep.cInit.y - 1) && (Math.abs(dep.cFinal.x - dep.cInit.x) == 1);
    }

}
