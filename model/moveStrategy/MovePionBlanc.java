package model.moveStrategy;

public class MovePionBlanc extends MovePion {


    @Override
    protected boolean isVertiacalOk(int yFinal) {
        return yFinal - this.dep.cInit.y < 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.dep.cInit.y - 1) && (Math.abs(xFinal - this.dep.cInit.x) == 1);
    }

}
