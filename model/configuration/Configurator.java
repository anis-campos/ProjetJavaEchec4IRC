package model.configuration;

import model.moveStrategy.IMoveStrategyFactory;
import model.moveStrategy.MoveStrategyStandardFactory;
import model.moveStrategy.MoveStrategyTempestFactory;

/**
 * Created by Anis on 11/05/2016.
 */
public class Configurator {

    private static Configurator instance;
    IFactoryManager factoryManager;
    private GameMode mode;

    private Configurator() {
        factoryManager = FactoryManager.getInstance();
        this.mode = GameMode.Standard;
    }

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }

        return instance;
    }

    public GameMode getMode() {
        return mode;
    }


    public void setMode(GameMode mode) {
        this.mode = mode;

    }

    private void applyMode() {
        switch (mode) {

            case Standard:
                factoryManager.bind(IMoveStrategyFactory.class, MoveStrategyStandardFactory.class);
                break;
            case Tempest:
                factoryManager.bind(IMoveStrategyFactory.class, MoveStrategyTempestFactory.class);
                break;
            case Others:
                break;
        }
    }
}
