package model.moveStrategy;


import model.common.Deplacement;

public class MovePionNoir extends MovePion {

	private static MovePionNoir instance;
	
	private MovePionNoir() {
	}
	
	public static MovePionNoir getInstance(){
		if (instance == null) {
            instance = new MovePionNoir();
        }

        return instance;
	}

    @Override
    protected boolean isVerticalOk(Deplacement dep) {
        return dep.cFinal.y - dep.cInit.y > 0;
    }

    @Override
    protected boolean isDiagonalOk(Deplacement dep) {
        return (dep.cFinal.y == dep.cInit.y + 1) && (Math.abs(dep.cFinal.x - dep.cInit.x) == 1);
    }


}
