package model.tempest;

/**
 * Created by Anis on 10/05/2016.
 */
public interface MoveStrategy {

    boolean isMoveOkStandard(int xFinal,  int yFinal);
    boolean isMoveOkTempest(int xFinal, int yFinal);
}
