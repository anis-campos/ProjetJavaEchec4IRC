package model;

/**
 * Created by Anis on 29/04/2016.
 */
public class PionBlanc extends Pion {

    /**
     * @param coord
     */
    public PionBlanc(Couleur couleur_de_piece, Coord coord) {
        super(Couleur.BLANC, coord);
    }

    @Override
    protected boolean isVertiacalOk(int yFinal) {
        return yFinal - this.getY() < 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.getY() - 1) && (Math.abs(xFinal-this.getX()) == 1);
    }
}
