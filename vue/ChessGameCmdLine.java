package vue;

import controler.ChessGameControlers;
import model.common.Coord;
import model.configuration.GameMode;
import model.pieces.PieceIHM;

import java.util.HashMap;
import java.util.List;


/**
 * @author francoise.perrin
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 *         <p>
 *         Vue console d'un jeu d'échec
 *         Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 */
public class ChessGameCmdLine extends AbstractView {



    public ChessGameCmdLine(ChessGameControlers chessGameControler) {
        super(chessGameControler);
    }


    public void go() {

        System.out.print("\n Déplacement de 3,6 vers 3,4 = ");
        chessGameControler.move(new Coord(3, 6), new Coord(3, 4));    // true

        System.out.print("\n Déplacement de 3,4 vers 3,6 = ");
        chessGameControler.move(new Coord(3, 4), new Coord(3, 6));    // false


        System.out.print("\n Déplacement de 4,1 vers 4,3 = ");
        chessGameControler.move(new Coord(4, 1), new Coord(4, 3));    // true


        System.out.print("\n Déplacement de 3,4 vers 3,4 = ");
        chessGameControler.move(new Coord(3, 4), new Coord(3, 4));    // false


        System.out.print("\n Déplacement de 3,4 vers 4,3 = ");
        chessGameControler.move(new Coord(3, 4), new Coord(4, 3));    // true

    }

    private HashMap<Coord,PieceIHM> mapper(List<PieceIHM> list){
        HashMap<Coord,PieceIHM> map = new HashMap<>();
        for (PieceIHM p : list){
            map.put(new Coord(p.getX(),p.getY()),p);
        }
        return map;
    }


    @Override
    public void display(List<PieceIHM> pieces) {
        System.out.println(chessGameControler.getMessage() + "\n");
        System.out.println("\t 0\t\t 1\t\t 2\t\t 3\t\t 4\t\t 5\t\t 6\t\t 7");

        Object[] array = pieces.toArray();

        HashMap<Coord,PieceIHM> map = mapper(pieces);
        for (int y = 0; y < 8; y++) {
            System.out.print(y);
            for (int x = 0; x < 8; x++) {
                PieceIHM pieceIHM = map.get(new Coord(x, y));
                String casse = pieceIHM == null ? "____" : pieceIHM.getNameSimple();
                System.out.print("\t" + casse);
            }
            System.out.println("");
        }

        String repeated = new String(new char[100]).replace("\0", "-");
        System.out.println("\n" + repeated);
    }

    @Override
    public void promotionCandidate(Coord coord) {

    }

    @Override
    public void EchecDetected() {

    }

    @Override
    public void End() {

    }

    @Override
    public void start() {

    }
    
    @Override
    public void highlight(List<Coord> patern) {

    }


	@Override
	public void changeMode(GameMode mode) {
		// TODO Auto-generated method stub
		
	}
}
