package model.moveStrategy;

import model.common.Deplacement;

public class MoveTour implements MoveStrategy {

    private static MoveTour instance;

    private MoveTour() {
    }


    public static MoveTour getInstance(){
        if(instance ==null)
            instance = new MoveTour();
        return instance;
    }


    @Override
    public boolean isMoveOk(Deplacement dep) {
        boolean ret = false;

        if ((dep.cFinal.y == dep.cInit.y) || (dep.cFinal.x == dep.cInit.x)) {
            ret = true;
        }

        return ret;
    }

}
