package model.common;

/**
 * Created by Anis on 10/05/2016.
 */
public class Deplacement {

    public Coord cInit;
    public Coord cFinal;
    public Boolean premierCoup;

    public boolean isCatchOk;
    public boolean isCastlingPossible;

    public Deplacement(Coord cInit, Coord cFinal, Boolean premierCoup, boolean isCatchOk, boolean isCastlingPossible) {
        this.cInit = cInit;
        this.cFinal = cFinal;
        this.premierCoup = premierCoup;
        this.isCatchOk = isCatchOk;
        this.isCastlingPossible = isCastlingPossible;
    }
}
