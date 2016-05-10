package tools;

import model.Couleur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author francoise.perrin
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 *         <p>
 *         Cette classe s'appuie sur ChessPieceImage
 *         pour fournir les noms des images des pièces
 *         qui sont utilisées dans l'IHM
 */
public class ChessImageProvider {

    private static Map<String, String> mapImage;

    static {
        mapImage = new HashMap<String, String>();
        for (int i = 0; i < ChessPieceImage.values().length; i++) {
            mapImage.put(ChessPieceImage.values()[i].nom, ChessPieceImage.values()[i].imageFile);
        }
    }

    /**
     * private pour ne pas instancier d'objets
     */
    private ChessImageProvider() {

    }

    /**
     * @param pieceType
     * @param pieceCouleur
     * @return nom fichier contenant image de la pi�ce
     */
    public static String getImageFile(String pieceType, Couleur pieceCouleur) {

        String FileName = mapImage.get(pieceType + pieceCouleur.name());
        String pathEncoded = ChessImageProvider.class.getResource("/images/" + FileName).getPath();
        try {
            return URLDecoder.decode(pathEncoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getImage(String pieceType, Couleur pieceCouleur) {

        String imagePath = getImageFile(pieceType, pieceCouleur);

        File file = new File(imagePath);

        if (file.exists() && file.isFile()){
            try {
                return ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    /**
     * Test unitaires
     *
     * @param args
     */
    public static void main(String[] args) {
        String cavalier = ChessImageProvider.getImageFile("Cavalier", Couleur.BLANC);
        System.out.println(cavalier);
        File f = new File(cavalier);

        System.out.println("Fichier existe: " + f.exists());
    }

}
