package model.game;


import model.common.Couleur;

/**
 * @author francoise.perrin
 * 
 * Cette interface défini le comportement attendu 
 * des jeux de plateaux
 *
 */
public interface BoardGames {	

	/**
	 * Permet de deplacer une piece connaissant ses coordonnees initiales 
	 * vers ses coordonnees finales 	 *  
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return OK si deplacement OK	 
	 */
	boolean move(int xInit, int yInit, int xFinal, int yFinal);

	/**
	 * @return true si c'est la fin du jeu
	 */
	boolean isEnd();

	/**
	 * @return un message sur l'état du jeu
	 */
	String getMessage();

	/**
	 * @return la couleur du jouer courant
	 */
	Couleur getColorCurrentPlayer();
	
	/**
	 * @param x
	 * @param y
	 * @return la couleur de la pièce sélectionnée
	 */
	Couleur getPieceColor(int x, int y);
 
}
