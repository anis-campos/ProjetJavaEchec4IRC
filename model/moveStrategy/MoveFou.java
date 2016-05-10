package model.moveStrategy;

public class MoveFou implements MoveStrategy {


    @Override
    public boolean isMoveOk(Deplacement dep) {
        boolean ret = false;

        if (Math.abs(dep.cFinal.y - dep.cInit.y) == Math.abs(dep.cFinal.x - dep.cInit.x)) {
            ret = true;
        }

        return ret;
    }

}
