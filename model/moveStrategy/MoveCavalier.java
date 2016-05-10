package model.moveStrategy;

public class MoveCavalier implements MoveStrategy {

	public MoveCavalier() {
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
