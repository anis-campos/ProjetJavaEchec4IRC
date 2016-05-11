package model.moveStrategy;

import model.common.Coord;

/**
 * Created by Anis on 10/05/2016.
 */
public class Deplacement {

    Coord cInit;
    Coord cFinal;
    Boolean premierCoup;

    boolean isCatchOk;
    boolean isCastlingPossible;

    public Deplacement(Coord cInit, Coord cFinal, Boolean premierCoup, boolean isCatchOk, boolean isCastlingPossible) {
        this.cInit = cInit;
        this.cFinal = cFinal;
        this.premierCoup = premierCoup;
        this.isCatchOk = isCatchOk;
        this.isCastlingPossible = isCastlingPossible;
    }
}
