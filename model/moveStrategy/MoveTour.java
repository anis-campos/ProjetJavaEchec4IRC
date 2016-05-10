package model.moveStrategy;

public class MoveTour implements MoveStrategy {

    public MoveTour() {
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
