package model.moveStrategy;

import model.common.Deplacement;

public class MoveReine implements MoveStrategy {

	private static MoveReine instance;

	private MoveReine() {
	}


	public static MoveReine getInstance() {
		if (instance == null)
			instance = new MoveReine();
		return instance;
	}


	@Override
	public boolean isMoveOk(Deplacement dep) {
		boolean ret = false;
	
	if (Math.abs(dep.cFinal.y - dep.cInit.y) == Math.abs(dep.cFinal.x - dep.cInit.x)
			|| ((dep.cFinal.y == dep.cInit.y) || (dep.cFinal.x == dep.cInit.x))) {
		ret =  true;
	}
	
	return ret;
	}

}
