package model.moveStrategy;

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
    protected boolean isVerticalOk(int yFinal) {
        return yFinal - this.dep.cInit.y < 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.dep.cInit.y - 1) && (Math.abs(xFinal - this.dep.cInit.x) == 1);
    }

}
