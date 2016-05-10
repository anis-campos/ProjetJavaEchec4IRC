package model.moveStrategy;

import model.pieces.AbstractPiece;
import tools.Introspection2;

/**
 * Created by Anis on 10/05/2016.
 */
public class MoveStrategyFactory {

    private static MoveStrategyFactory instance;
    private boolean tempestMode;


    //Cacher le constructeur
    private MoveStrategyFactory() {
        tempestMode = false;
    }

    public void setTempest(boolean bool) {
        this.tempestMode = bool;
    }

    public boolean isTempestMode() {
        return tempestMode;
    }

    public static MoveStrategyFactory getInstance() {
        if (instance == null) {
            instance = new MoveStrategyFactory();
        }

        return instance;

    }


    public MoveStrategy create(Class<? extends AbstractPiece> type, Deplacement dep) {
        String pieceName = type.getSimpleName();

        String MoveStrategyName = "model.tempest.Move" + pieceName;

        try {
            MoveStrategy moveStrategy = (MoveStrategy) Introspection2.newInstance(MoveStrategyName, type, dep);
            return moveStrategy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
