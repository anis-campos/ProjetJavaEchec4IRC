package model.observe.notification;

import model.Coord;
import model.pieces.PieceIHM;

import java.util.List;

/**
 * Created by Anis on 29/04/2016.
 */
public class PromotionNotification extends Notification {

    public PromotionNotification(Coord cPiece, List<PieceIHM> etatJeu) {
        super(cPiece,cPiece,etatJeu);
    }

}
