package vue;

import model.moveStrategy.MoveStrategyType;
import model.common.Coord;
import model.pieces.PieceIHM;

import java.util.List;

/**
 * Created by Anis on 09/05/2016.
 */
public interface IView {

    void display(List<PieceIHM> pieces);

    void undoMove();

    void redoMove();

    void promotionCandidate(Coord coord);

    void EchecDetected();

    void End();

    void start();
    
    void changeMode(GameMode mode);

    void highlight(List<Coord> patern);
}
