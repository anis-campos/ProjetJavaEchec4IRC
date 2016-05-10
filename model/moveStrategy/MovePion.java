package model.moveStrategy;

public abstract class MovePion implements MoveStrategy {

    protected Deplacement dep;

    @Override
    public boolean isMoveOk(Deplacement dep) {
        this.dep = dep;
        boolean ret = false;

        // Déplacement vertical
        if (!dep.isCatchOk && !dep.isCastlingPossible) {

            if ((dep.cFinal.x == dep.cInit.x)
                    && (Math.abs(dep.cFinal.y - dep.cInit.y) <= 1 ||
                    (Math.abs(dep.cFinal.y - dep.cInit.y) <= 2 && dep.premierCoup == true))) {

                ret = isVertiacalOk(dep.cFinal.y);
            }
        }
        // Déplacement diagonal
        else {
            ret = isDiagonalOk(dep.cFinal.x, dep.cFinal.y);
        }

        return ret;

    }


    protected abstract boolean isVertiacalOk(int yFinal);

    protected abstract boolean isDiagonalOk(int xFinal, int yFinal);


}
