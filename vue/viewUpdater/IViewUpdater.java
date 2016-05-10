package vue.viewUpdater;

import model.observe.notification.Notification;
import vue.IView;


/**
 * Created by Anis on 30/04/2016.
 *
 * Implementation du DP Command. Le but est de faciliter l'ajout de comportement aux Vues lors de
 * la reception de notifications.
 *
 * Cette version permet de passer des paramètres aux interpreteurs de la commande. L'interpreteur
 * est formé grace à au nom de la notification.
 *
 * Example :
 *  MoveNotification => MoveViewUpdater
 *
 *  Les interpreteurs étendent AbstractViewUpdateur.
 *
 * Remaque : Cela est possible grace à de l'introspection.
 *
 */
public interface IViewUpdater {

    void execute(Notification notif, IView view);

}
