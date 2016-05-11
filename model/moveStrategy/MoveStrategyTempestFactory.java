package model.moveStrategy;

import model.common.Deplacement;
import model.pieces.AbstractPiece;
import tools.Introspection;

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
	public MoveStrategy create(Class<? extends AbstractPiece> type, Deplacement deplacement) {
		String pieceName = null;

		if(deplacement.cInit.x == 0 || deplacement.cInit.x == 7){
			pieceName = "Tour";
		}
		else if(deplacement.cInit.x == 1 || deplacement.cInit.x == 6){
			pieceName = "Cavalier";
		}
		else if(deplacement.cInit.x == 2 || deplacement.cInit.x == 5){
			pieceName = "Fou";
		}
		else{
			pieceName = type.getSimpleName();
		}
		
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
