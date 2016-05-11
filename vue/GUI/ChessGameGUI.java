package vue.GUI;

import controler.ChessGameControlers;
import model.common.Coord;
import model.pieces.PieceIHM;
import vue.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by Anis on 09/05/2016.
 */
public class ChessGameGUI extends AbstractView implements MouseListener, MouseMotionListener {

    private JFrame frame;


    private Dimension boardSize;

    private JPanel layeredPaneGame;

    private JLayeredPane layeredPaneDamier;

    private Damier damier;

    private JLabel pieceToMove;

    private JPanel pieceToMoveSquare;


    private int xAdjustment;

    private int yAdjustment;

    private JLabel sauvPieceToMove;


    public ChessGameGUI(String Title, ChessGameControlers chessGameControler, Dimension dim) {
        super(chessGameControler);
        this.initFields(Title, dim);
        this.setLayout();
        this.setListener();

        frame.setPreferredSize(dim);
        frame.pack();

    }

    private void setListener() {
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    private void setLayout() {

        this.frame.setContentPane(layeredPaneGame);

        this.layeredPaneGame.setLayout(new BorderLayout());

        this.layeredPaneGame.add(layeredPaneDamier, BorderLayout.CENTER);

        damier.setBounds(0, 0, this.boardSize.width, this.boardSize.height);
        this.layeredPaneDamier.add(this.damier, JLayeredPane.DEFAULT_LAYER);

        frame.revalidate();

    }


    private void initFields(String Title, Dimension dim) {
        frame = new JFrame(Title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 10);


        this.boardSize = dim;

        frame.setResizable(true);

        this.damier = new Damier();

        this.layeredPaneGame = new JPanel();

        this.layeredPaneDamier = new JLayeredPane();
    }


    @Override
    public void display(List<PieceIHM> pieces) {
        damier.update(pieces);
        frame.revalidate();
    }

    @Override
    public void undoMove() {
        sauvPieceToMove.setVisible(true);
        frame.revalidate();
    }

    @Override
    public void redoMove() {

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
        frame.setVisible(true);
    }

    @Override
    public void highlight(List<Coord> patern) {
        damier.highlightSquares(patern);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pieceToMoveLocation = null;

        Component c = this.damier.findComponentAt(e.getX() - 10, e.getY() - 30);

        this.pieceToMove = null;

        // si l'utilisateur a s�lectionn� une pi�ce
        if (c instanceof JLabel) {

            this.pieceToMove = (JLabel) c;
            this.pieceToMoveSquare = (JPanel) c.getParent();

            Coord initCoord = this.damier.getCoord(this.pieceToMoveSquare);

            if(!this.chessGameControler.isPlayerOK(initCoord)){
            	this.pieceToMove = null;
            	this.pieceToMoveSquare = null;
            	return;
            }
            
            // avant de d�placer la pi�ce, on en positionne un clone invisible
            // au m�me endroit : cela servira lors du rafraichissement de la fen�tre (update)
            sauvPieceToMove = new JLabel(this.pieceToMove.getIcon());
            sauvPieceToMove.setVisible(false);
            this.pieceToMoveSquare.add(sauvPieceToMove);

            pieceToMoveLocation = this.pieceToMoveSquare.getLocation();
            this.xAdjustment = pieceToMoveLocation.x - e.getX();
            this.yAdjustment = pieceToMoveLocation.y - e.getY();

            this.pieceToMove.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            this.pieceToMove.setSize(pieceToMove.getWidth(), pieceToMove.getHeight());
            this.layeredPaneDamier.add(pieceToMove, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Coord initCoord = null, finalCoord = null;
        Component targetedComponent = null;
        JPanel targetSquare;

        if (this.pieceToMove == null || pieceToMoveSquare == null) {
            return;
        }

        this.pieceToMove.setVisible(false);

        // r�cup�ration du composant qui se trouve � position (pixel) finale
        targetSquare = this.damier.findSquareAt(e.getX() - 10, e.getY() - 30);

        // r�cup�ration coordonn�es initiales et finales de la pi�ce � d�placer
        // en vue du d�placement m�tier
        initCoord = this.damier.getCoord(this.pieceToMoveSquare);
        finalCoord = this.damier.getCoord(targetSquare);

        // Si les coordonn�es finales sont en dehors du damier, on les force � -1
        // cela permettra � la m�thode chessGame.move de g�rer le message d'erreur
        if (finalCoord == null) {
            finalCoord = new Coord(-1, -1);
        }

        // Invoque la m�thode de d�placement de l'�chiquier
        this.chessGameControler.move(initCoord, finalCoord);

        // l'�chiquier est observ� par cette fen�tre
        // d�s lors qu'il est modifi�, la vue en est avertie
        // la m�thode update est appel�e pour rafraichir l'affichage
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.pieceToMove != null && pieceToMoveSquare != null) {
            this.pieceToMove.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
