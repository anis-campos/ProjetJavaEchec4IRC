package model.moveStrategy;

import model.common.Deplacement;

public class MoveRoi implements IMoveStrategy {

    private static MoveRoi instance;

    private MoveRoi() {
    }


    public static MoveRoi getInstance() {
        if (instance == null)
            instance = new MoveRoi();
        return instance;
    }


    @Override
    public boolean isMoveOk(Deplacement dep) {
        boolean ret = false;

        if ((Math.abs(dep.cFinal.y - dep.cInit.y) <= 1)
                && (Math.abs(dep.cFinal.x - dep.cInit.x) <= 1)) {
            ret = true;
        }


        return ret;
    }

}
