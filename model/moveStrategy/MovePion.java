package model.moveStrategy;

import model.common.Deplacement;

public abstract class MovePion implements IMoveStrategy {

    protected MovePion() {
    }

    @Override
    public boolean isMoveOk(Deplacement dep) {
        boolean ret = false;

        // Déplacement vertical
        if (!dep.isCatchOk && !dep.isCastlingPossible) {

            if ((dep.cFinal.x == dep.cInit.x)
                    && (Math.abs(dep.cFinal.y - dep.cInit.y) <= 1 ||
                    (Math.abs(dep.cFinal.y - dep.cInit.y) <= 2 && dep.premierCoup == true))) {

                ret = isVerticalOk(dep);
            }
        }
        // Déplacement diagonal
        else {
            ret = isDiagonalOk(dep);
        }

        return ret;

    }


    protected abstract boolean isVerticalOk(Deplacement dep);

    protected abstract boolean isDiagonalOk(Deplacement dep);


}
