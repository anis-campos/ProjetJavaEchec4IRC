package controler.controlerLocal;

import controler.ChessGameControlers;
import model.game.ChessGame;
import model.common.Coord;

/**
 * Created by Anis on 27/04/2016.
 */
public class ChessGameControler implements ChessGameControlers {

    private ChessGame model;

    public ChessGameControler(ChessGame model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model.toString();
    }

    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {

        return model.move(initCoord.x,initCoord.y,finalCoord.x,finalCoord.y);
    }

    @Override
    public String getMessage() {
        return model.getMessage();
    }

    @Override
    public boolean isEnd() {
        return model.isEnd();
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        return model.isPlayerOK(initCoord);
    }
}
