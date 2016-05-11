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

    private Configurator() {
        factoryManager = FactoryManager.getInstance();
    }

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }

        return instance;
    }


    public void setMode(GameMode mode) {
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
