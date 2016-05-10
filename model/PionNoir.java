package model;

/**
 * Created by Anis on 29/04/2016.
 */
public class PionNoir extends Pion {

    /**
     * @param coord
     */
    public PionNoir(Couleur couleur_de_piece, Coord coord) {
        super(Couleur.NOIR, coord);
    }

    @Override
    protected boolean isVertiacalOk(int yFinal) {

        return yFinal - this.getY() > 0;
    }

    @Override
    protected boolean isDiagonalOk(int xFinal, int yFinal) {
        return (yFinal == this.getY() + 1 && xFinal == this.getX() + 1) || (yFinal == this.getY() + 1 && xFinal == this.getX() - 1);
    }
}