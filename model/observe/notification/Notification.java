package model.observe.notification;

import model.common.Coord;
import model.pieces.PieceIHM;

import java.util.List;


/**
 * Created by Anis on 29/04/2016.
 */
abstract public class Notification {
    //description du mouvement normale d'une pièce

    public Coord cInit;
    public Coord cFinal;

    public List<PieceIHM> etatJeu;


    protected Notification(Coord cInit, Coord cFinal, List etatJeu) {
        this.cInit = cInit;
        this.cFinal = cFinal;
        this.etatJeu = etatJeu;
    }


}
