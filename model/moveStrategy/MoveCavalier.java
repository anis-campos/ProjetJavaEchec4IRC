package model.moveStrategy;

import model.common.Deplacement;

public class MoveCavalier implements MoveStrategy {

	private static MoveCavalier instance;
	
	private MoveCavalier() {
	}
	
	public static MoveCavalier getInstance(){
		if (instance == null) {
            instance = new MoveCavalier();
        }

        return instance;
	}

	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
		
		if ((Math.abs(dep.cFinal.x - dep.cInit.x) + Math.abs(dep.cFinal.y - dep.cInit.y)) == 3) {
			
			if ((Math.abs(dep.cFinal.x - dep.cInit.x)<3) && (Math.abs(dep.cFinal.y - dep.cInit.y)<3)) {
				ret  = true;
			}		
		}	
		return ret;
	}

}
