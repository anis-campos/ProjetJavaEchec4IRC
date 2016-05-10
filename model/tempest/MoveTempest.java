package model.tempest;

import model.pieces.AbstractPiece;
import model.moveStrategy.AbstractMoveStrategy;
import model.moveStrategy.Deplacement;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveTempest extends AbstractMoveStrategy {

    public MoveTempest(Class<? extends AbstractPiece> type, Deplacement deplacement) {
        super(type, deplacement);
    }

    @Override
    public boolean isMoveOk(Deplacement dep) {

        return false;


    }
}
