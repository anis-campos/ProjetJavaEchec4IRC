package model.observe.notification;

import model.common.Coord;

import java.util.List;

/**
 * Created by Anis on 10/05/2016.
 */
public class HighlightNotification extends Notification {

    public final List<Coord> patern;

    public HighlightNotification(Coord cInit, List<Coord> patern) {
        super(cInit, null, null);
        this.patern = patern;
    }
}
