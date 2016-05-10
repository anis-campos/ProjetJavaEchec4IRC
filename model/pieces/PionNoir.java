package model.pieces;

import model.Coord;
import model.Couleur;

/**
 * Created by Anis on 29/04/2016.
 */
public class PionNoir extends Pion {

    /**
     *
     * @param couleur_de_piece
     * @param coord
     */
    public PionNoir(Couleur couleur_de_piece, Coord coord) {
        super(Couleur.NOIR, coord);
    }
}