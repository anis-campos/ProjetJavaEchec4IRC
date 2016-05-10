package model;

import model.observe.IObserver;
import model.observe.Observable;
import model.observe.notification.*;

/**
 * Created by Anis on 29/04/2016.
 */
public class ChessGame extends Observable {

    private Echiquier echiquier;

    public ChessGame() {
        this.echiquier = new Echiquier();
    }

    @Override
    public void afterAdd(IObserver observer) {
        observer.update(new StartNotification(echiquier.getPiecesIHM()));
    }


    public String toString() {
        return echiquier.toString() + getMessage();
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if (echiquier.isMoveOk(xInit, yInit, xFinal, yFinal))
            if (echiquier.move(xInit, yInit, xFinal, yFinal)) {
                echiquier.switchJoueur();
                notifyObservers(new MoveNotification(new Coord(xInit, yInit), new Coord(xFinal, yFinal), echiquier.getPiecesIHM(), false));
                if (echiquier.isEchec())
                    notifyObservers(new EchecNotification(new Coord(xInit, yInit), new Coord(xFinal, yFinal), echiquier.getPiecesIHM()));
                return true;
            }
        notifyObservers(new IllegalMoveNotification(new Coord(xInit, yInit), new Coord(xFinal, yFinal), echiquier.getPiecesIHM()));
        return false;

    }


    public boolean isEnd() {
        return echiquier.isEnd();
    }

    public String getMessage() {
        return echiquier.getMessage();
    }

    public Couleur getColorCurrentPlayer() {
        return echiquier.getColorCurrentPlayer();
    }

    public boolean isPlayerOK(Coord pieceCoord) {

        if(echiquier.isPlayerOk(pieceCoord))
            notifyObservers(new HighlightNotification(pieceCoord, echiquier.getPatern(pieceCoord)));

        return echiquier.isPlayerOk(pieceCoord);
    }
}

