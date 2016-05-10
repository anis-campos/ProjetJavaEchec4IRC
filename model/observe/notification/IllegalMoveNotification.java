package model.observe.notification;

import model.Coord;
import model.pieces.PieceIHM;

import java.util.List;

/**
 * Created by Anis on 29/04/2016.
 */
public class IllegalMoveNotification extends Notification{

    public IllegalMoveNotification(Coord cInit, Coord cFinal, List<PieceIHM> etatJeu)
    {
        super(cInit,cFinal,etatJeu);
    }

}