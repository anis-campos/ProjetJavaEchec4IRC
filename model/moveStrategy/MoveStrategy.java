package model.moveStrategy;

import model.common.Deplacement;

/**
 * Created by Anis on 10/05/2016.
 */
public interface MoveStrategy {

    boolean isMoveOk(Deplacement dep);

}
