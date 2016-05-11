package model.pieces;

import model.common.Coord;
import model.common.Couleur;

/**
 * Created by Anis on 29/04/2016.
 */
public class PieceIHM {

    private Pieces piece;

    public PieceIHM(Pieces piece) {
        this.piece = piece;
    }

    public String getNameSimple() {
        String name = getCouleur() == Couleur.BLANC ? "B_" : "N_";
        name += piece.getName().substring(0, 2);
        return name;
    }

    public boolean isCaptured(){
        return !Coord.coordonnees_valides(getX(),getY());
    }

    public String getName() {
        return piece.getName();
    }

    public Couleur getCouleur() {
        return piece.getCouleur();
    }

    public int getX() {
        return piece.getX();
    }

    public int getY() {
        return piece.getY();
    }


}
