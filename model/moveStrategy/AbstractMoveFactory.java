package model.moveStrategy;

import tools.Introspection;

/**
 * Created by Anis on 10/05/2016.
 */
public class AbstractMoveFactory {


    private static AbstractMoveFactory instance;

    private AbstractMoveFactory() {
        type = MoveStrategyType.Standard;
    }

    public static AbstractMoveFactory getInstance() {
        if (instance == null) {
            instance = new AbstractMoveFactory();
        }

        return instance;
    }

    private MoveStrategyType type;

    public void setType(MoveStrategyType type) {
        this.type = type;
    }

    public MoveStrategyType getType() {
        return type;
    }

    public IMoveStrategyFactory getFactory() {
        String typeString = type.toString();
        String factoryName = "model.moveStrategy.MoveStrategy" + typeString + "Factory";

        IMoveStrategyFactory rep = null;
        try {
            rep = (IMoveStrategyFactory) Introspection.invokeStatic(factoryName, null, "getInstance");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rep;
    }
}
