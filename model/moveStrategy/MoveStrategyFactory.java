package model.moveStrategy;

import model.pieces.AbstractPiece;
import tools.Introspection2;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveStrategyFactory {

    private static MoveStrategyFactory instance;


    //Cacher le constructeur
    private MoveStrategyFactory() {
    }


    public static MoveStrategyFactory getInstance() {
        if (instance == null) {
            instance = new MoveStrategyFactory();
        }

        return instance;

    }


    public MoveStrategy create(Class<? extends AbstractPiece> type) {
        String pieceName = type.getSimpleName();

        String MoveStrategyName = "model.tempest.Move" + pieceName;

        try {
            MoveStrategy moveStrategy = (MoveStrategy) Introspection2.newInstance(MoveStrategyName);
            return moveStrategy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
