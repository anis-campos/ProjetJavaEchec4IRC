package model.moveStrategy;

import model.pieces.AbstractPiece;

public class MoveStrategyTempestFactory implements IMoveStrategyFactory{

    private static MoveStrategyTempestFactory instance;

    //Cacher le constructeur
    private MoveStrategyTempestFactory() {
    }

    public static MoveStrategyTempestFactory getInstance() {
        if (instance == null) {
            instance = new MoveStrategyTempestFactory();
        }

        return instance;

    }

	@Override
	public MoveStrategy create(Class<? extends AbstractPiece> type) {
		// TODO Auto-generated method stub
		return null;
	}

}
