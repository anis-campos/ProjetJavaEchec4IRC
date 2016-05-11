package vue.GUI;

import model.common.Coord;
import model.pieces.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

/**
 * Created by Anis on 09/05/2016.
 */
public class Damier extends JPanel {

    private BiMap<Coord, JPanel> map;

    public Damier() {
        this.map = new BiMap<>();
        this.setLayout(new GridLayout(8, 8));
        initDamier();
    }

    private void initDamier() {
        JPanel square;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                square = newSquare(i, j);
                Coord c = new Coord(i, j);
                map.put(c, square);
                this.add(square);
            }
        }
    }

    private JPanel newSquare(int i, int j) {
        JPanel square;

        if (i % 2 == 0) {
            if (j % 2 != 0)
                square = new SquareNoire();
            else
                square = new SquareBlanc();
        } else {
            if (j % 2 != 0)
                square = new SquareBlanc();
            else
                square = new SquareNoire();
        }
        return square;
    }

    public void clean() {

        for (JPanel panel : map.getValues()) {
            panel.removeAll();
            ((Square)panel).unfocus();
        }
    }

    public void update(List<PieceIHM> listPiece) {
        this.clean();
        for (PieceIHM p : listPiece) {
            if (!p.isCaptured()) {
                JPanel panel = map.getValue(new Coord(p.getX(), p.getY()));
                ImageIcon imageIcon = new ImageIcon(ChessImageProvider.getImage(p.getName(), p.getCouleur()));
                JLabel jLabel = new JLabel(imageIcon);
                panel.add(jLabel);
            }

        }
    }

    public void highlightSquares(List<Coord> coords) {

       for(Coord c : coords){
           Square s = (Square) map.getValue(c);
           s.focus();
       }

    }

    public JPanel findSquareAt(int x, int y) {
        JPanel targetSquare;
        Component targetedComponent = this.findComponentAt(x, y);

        // si c'est un carr� occup�, on a r�cup�r� une image de pi�ce
        // et il faut r�cup�rer le square qui la contient
        if (targetedComponent instanceof JLabel) {
            targetSquare = (JPanel) targetedComponent.getParent();
        } // si c'est un carr� vide
        else {
            targetSquare = (JPanel) targetedComponent;
        }

        Coord c = map.getKey(targetSquare);
        System.out.println(c);
        return targetSquare;

    }

    public Coord getCoord(JPanel square) {
        return map.getKey(square);
    }


    abstract class Square extends JPanel {

        Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);

        public Square() {
            super(new BorderLayout());
            this.setBorder(null);
        }

        void focus() {
            this.setBorder(redBorder);
        }

        void unfocus() {
            this.setBorder(null);
        }

    }

    class SquareBlanc extends Square {
        public SquareBlanc() {
            this.setBackground(new Color(242, 247, 255));
        }
    }

    class SquareNoire extends Square {
        public SquareNoire() {
            this.setBackground(new Color(48, 48, 48));
        }

    }

}
