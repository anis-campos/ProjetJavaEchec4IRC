package model.moveStrategy;

import model.common.Deplacement;

public abstract class MovePion implements MoveStrategy {

    protected Deplacement dep;


    protected MovePion() {
    }

    @Override
    public boolean isMoveOk(Deplacement dep) {
        this.dep = dep;
        boolean ret = false;

        // Déplacement vertical
        if (!dep.isCatchOk && !dep.isCastlingPossible) {

            if ((dep.cFinal.x == dep.cInit.x)
                    && (Math.abs(dep.cFinal.y - dep.cInit.y) <= 1 ||
                    (Math.abs(dep.cFinal.y - dep.cInit.y) <= 2 && dep.premierCoup == true))) {

                ret = isVerticalOk(dep.cFinal.y);
            }
        }
        // Déplacement diagonal
        else {
            ret = isDiagonalOk(dep.cFinal.x, dep.cFinal.y);
        }

        return ret;

    }


    protected abstract boolean isVerticalOk(int yFinal);

    protected abstract boolean isDiagonalOk(int xFinal, int yFinal);


}
