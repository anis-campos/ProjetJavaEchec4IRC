package model.moveStrategy;


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
    protected boolean isVerticalOk(int yFinal) {
        return yFinal - this.dep.cInit.y > 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.dep.cInit.y + 1) && (Math.abs(xFinal - this.dep.cInit.x) == 1);
    }


}
