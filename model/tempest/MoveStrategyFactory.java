package model.tempest;

import model.AbstractPiece;
import model.Coord;
import tools.Introspection2;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveStrategyFactory {

    //Cacher le constructeur
    private MoveStrategyFactory(){};

    public static MoveStrategy create(Class<? extends AbstractPiece> type, Coord init) {
        String pieceName = type.getSimpleName();

        String MoveStrategyName = "model.tempest.Move"+pieceName;

        try {
            MoveStrategy moveStrategy = (MoveStrategy) Introspection2.newInstance(MoveStrategyName, type, init);
            return moveStrategy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
