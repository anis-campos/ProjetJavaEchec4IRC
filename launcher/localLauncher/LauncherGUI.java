package launcher.localLauncher;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.game.ChessGame;
import vue.AbstractView;
import vue.GUI.ChessGameGUI;

import java.awt.*;

/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode graphique.
 * La vue (ChessGameGUI) observe le modèle (ChessGame)
 * les échanges passent par le contrôleur (ChessGameControlers)
 * 
 */
public class LauncherGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGame chessGame;
		ChessGameControlers chessGameControler;
		Dimension dim;
	
		dim = new Dimension(700, 700);
		
		chessGame = new ChessGame();	
		chessGameControler = new ChessGameControler(chessGame);

		AbstractView frame = new ChessGameGUI("Jeu d'�chec", chessGameControler,  dim);

		chessGame.addObserver(frame);
		

	}
}
