package tools;

import junit.framework.TestCase;
import model.Couleur;
import model.Pieces;

import java.io.File;
import java.util.List;

/**
 * Created by Anis on 09/05/2016.
 */
public class ChessImageProviderTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetImageFile() throws Exception {

        for (Couleur c : Couleur.values()){
            List<Pieces> pieces = ChessPiecesFactory.newPieces(c);
            for(Pieces piece : pieces){
                String imageFile = ChessImageProvider.getImageFile(piece.getName(), c);
                File f = new File(imageFile);
                assertTrue(f.exists());
                //System.out.println(f.getPath());
            }
        }


    }
}