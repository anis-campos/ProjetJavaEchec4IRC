package vue.GUI;

import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
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
                square = newSquare(j, i);
                Coord c = new Coord(j, i);
                map.put(c, square);
                this.add(square);
            }
        }
    }

    private JPanel newSquare(int i, int j) {
        JPanel square = new JPanel(new BorderLayout());
        int row = i % 2;
        if (row == 0) {
            square.setBackground(j % 2 != 0 ? new Color(48, 48, 48) : new Color(242, 247, 255));
        } else {
            square.setBackground(j % 2 != 0 ? new Color(242, 247, 255) : new Color(48, 48, 48));
        }
        return square;
    }

    public void clean() {

        for (JPanel panel : map.getValues()) {
            panel.removeAll();
        }
    }

    public void update(List<PieceIHM> listPiece) {
        this.clean();
        for (PieceIHM p : listPiece) {
            if(!p.isCaptured()){
                JPanel panel = map.getValue(new Coord(p.getX(), p.getY()));
                ImageIcon imageIcon = new ImageIcon(ChessImageProvider.getImage(p.getName(), p.getCouleur()));
                JLabel jLabel = new JLabel(imageIcon);
                panel.add(jLabel);
            }

        }
    }

    public JPanel findSquareAt(int x, int y){
        JPanel targetSquare;
        Component targetedComponent = this.findComponentAt(x,y);

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
}
