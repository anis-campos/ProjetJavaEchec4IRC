package model.moveStrategy;

import model.pieces.AbstractPiece;
import tools.Introspection;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveStrategyFactory implements IMoveStrategyFactory{

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

        String MoveStrategyName = "model.moveStrategy.Move" + pieceName;

        MoveStrategy rep = null;
        try {
            rep = (MoveStrategy) Introspection.invokeStatic(MoveStrategyName, null, "getInstance");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rep;
    }
}
