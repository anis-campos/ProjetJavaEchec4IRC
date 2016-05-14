package model.pieces;

import model.common.Couleur;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public interface Pieces {

	/**
	 * @return indice de la colonne où est positionnée la piece
	 */
	int getX();
	
	/**
	 * @return indice de la ligne où est positionnée la piece
	 */
	int getY();
	
	/**
	 * @return couleur de la piece
	 */
	Couleur getCouleur();
	
	/**
	 * @return le nom de la pièce (Tour, Cavalier, etc.)
	 * attention le type ne correspond pas forcément au nom de la classe
	 */
	String getName();

	/**
	 * @param xFinal
	 * @param yFinal
	 * @param isCastlingPossible 
	 * @param isCatchOk 
	 * @return true si déplacement légal en fonction des algo
	 * de déplacement spécifique de chaque pièce
	 */
	boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);
	
	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true si d�placement effectu�
	 */
	boolean move(int xFinal, int yFinal);
	
	/** 
	 * @return true si piece effectivement captur�e
	 * Positionne x et y à -1
	 */
	boolean capture();

	void undoCapture(int x, int y);

	void undoMove(int x, int y);

	boolean isFirstMove();
}

