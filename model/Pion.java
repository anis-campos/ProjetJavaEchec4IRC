package model;


/**
 * @author francoise.perrin
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
abstract class Pion extends AbstractPiece {

    private boolean premierCoup;

    /**
     * @param couleur_de_piece
     * @param coord
     */
    protected Pion(Couleur couleur_de_piece, Coord coord) {
        super(couleur_de_piece, coord);
        this.premierCoup = true;
    }

    /* (non-Javadoc)
     * @see model.AbstractPiece#isMoveOk(int, int)
     */
    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
                            boolean isCastlingPossible) {

        boolean ret = false;

        // Déplacement vertical
        if (!isCatchOk && !isCastlingPossible) {

            if ((xFinal == this.getX())
                    && (Math.abs(yFinal - this.getY()) <= 1 ||
                    (Math.abs(yFinal - this.getY()) <= 2 && this.premierCoup == true))) {

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

    /* (non-Javadoc)
     * @see model.AbstractPiece#move(int, int)
     */
    @Override
    public boolean move(int x, int y) {

        boolean ret = false;

        if (Coord.coordonnees_valides(x, y)) {
            this.premierCoup = false;
            ret = super.move(x, y);
        }
        return ret;
    }




}
