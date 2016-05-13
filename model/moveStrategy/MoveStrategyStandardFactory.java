package model.moveStrategy;

import model.common.Deplacement;
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


    public IMoveStrategy create(Class<? extends AbstractPiece> type, Deplacement deplacement) {
        String pieceName = type.getSimpleName();

        String MoveStrategyName = "model.moveStrategy.Move" + pieceName;

        IMoveStrategy rep = null;
        try {
            rep = (IMoveStrategy) Introspection.invokeStatic(MoveStrategyName, null, "getInstance");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rep;
    }
}
