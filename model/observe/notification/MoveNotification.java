package model.observe.notification;

import model.Coord;
import model.PieceIHM;

import java.util.List;


/**
 * Created by Anis on 29/04/2016.
 */

public class MoveNotification extends Notification {

    public boolean isPionToPromote;

    public MoveNotification(Coord cInit, Coord cFinal, List<PieceIHM> etatJeu, boolean isPionToPromote) {
        super(cInit,cFinal,etatJeu);
        this.isPionToPromote = isPionToPromote;
    }

}

