package model.moveStrategy;

import model.pieces.AbstractPiece;
import tools.Introspection;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveStrategyStandardFactory implements IMoveStrategyFactory{

    private static MoveStrategyStandardFactory instance;


    //Cacher le constructeur
    private MoveStrategyStandardFactory() {
    }


    public static MoveStrategyStandardFactory getInstance() {
        if (instance == null) {
            instance = new MoveStrategyStandardFactory();
        }

        return instance;

    }


    public MoveStrategy create(Class<? extends AbstractPiece> type, Deplacement deplacement) {
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
