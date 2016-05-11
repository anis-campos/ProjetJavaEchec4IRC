package controler;

import model.common.Coord;

public interface ChessGameControlers {

	
	/**
	 * @param initCoord
	 * @param finalCoord
	 * @return true si le déplacement s'est bien passé
	 */
	boolean move(Coord initCoord, Coord finalCoord);

	/**
	 * @return message relatif aux déplacement, capture, etc.
	 */
	String getMessage();
	
	/**
	 * @return true si fin de partie OK (echec et mat, pat, etc.)
	 */
	boolean isEnd();


	/**
	 * @param initCoord
	 * @return une info dont la vue se servira 
	 * pour empêcher tout déplacement sur le damier
	 */
	boolean isPlayerOK(Coord initCoord);



}
