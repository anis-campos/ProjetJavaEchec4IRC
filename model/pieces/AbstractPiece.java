package model.pieces;


import model.common.Coord;
import model.common.Couleur;
import model.common.Deplacement;
import model.configuration.FactoryManager;
import model.configuration.IFactoryManager;
import model.moveStrategy.IMoveStrategy;
import model.moveStrategy.IMoveStrategyFactory;

/**
 * @author francoise.perrin
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 *         G�re le comportement commun � toutes les pi�ces
 *         Chaque classe d�riv�e (Pion, etc.) sera capable de dire
 *         si le d�placement est OK.
 */
public abstract class AbstractPiece implements Pieces {

    private final IFactoryManager manager = FactoryManager.getInstance();
    private int x;
    private int y;
    private Couleur couleur;
    private boolean premierCoup;
    private IMoveStrategy move;

    private int nbcoups;

    /**
     * @param couleur
     * @param coord
     */
    public AbstractPiece(Couleur couleur, Coord coord) {
        this.x = coord.x;
        this.y = coord.y;
        this.couleur = couleur;
        this.premierCoup = true;
        nbcoups = 0;
    }

    /* (non-Javadoc)
     * @see model.Pieces#getX()
     */
    public int getX() {
        return this.x;
    }

    /* (non-Javadoc)
     * @see model.Pieces#getY()
     */
    public int getY() {
        return this.y;
    }

    /* (non-Javadoc)
     * @see model.Pieces#getCouleur()
     */
    public Couleur getCouleur() {
        return this.couleur;
    }

    /* (non-Javadoc)
     * @see model.piece.Pieces#getType()
     */
    public String getName() {
        return getClass().getSimpleName();
    }

    /* (non-Javadoc)
     * @see model.Pieces#move(int, int)
     *
     * Déplace une pièce
     */
    public boolean move(int x, int y) {
        boolean ret = false;
        if (Coord.coordonnees_valides(x, y)) {
            this.x = x;
            this.y = y;
            ret = true;
            premierCoup = false;
            nbcoups++;
        }
        return ret;

    }

    /* (non-Javadoc)
     * @see model.Pieces#capture()
     *
     * Capture une piece :
     * passer ses coordonn�es � -1
     */
    public boolean capture() {
        this.x = -1;
        this.y = -1;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     *
     */
    public String toString() {
        String S = (this.getClass().getSimpleName()).substring(0, 2)
                + " " + this.x + " " + this.y;

        return S;
    }


    /* (non-Javadoc)
     * @see model.Pieces#isMoveOk(int, int)
     *
     * En fonction du type de pièce (Pion, etc.)
     * est capable de dire si le déplacement est OK
     */
    public final boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk,
                                  boolean isCastlingPossible) {

        Deplacement dep = new Deplacement(new Coord(getX(), getY()), new Coord(xFinal, yFinal),
                premierCoup, isCatchOk, isCastlingPossible);


        IMoveStrategyFactory factory = manager.getFactory(IMoveStrategyFactory.class);


        if (factory != null) {
            move = factory.create(this.getClass(), dep);

            return move.isMoveOk(dep);
        }
        return false;

    }

    @Override
    public void undoMove(int x, int y) {
        if (Coord.coordonnees_valides(x, y)) {
            this.x = x;
            this.y = y;
            if (nbcoups == 1) {
                premierCoup = true;
            }
            nbcoups--;
        }

    }

    @Override
    public boolean isFirstMove() {
        return premierCoup;
    }

    @Override
    public void undoCapture(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

