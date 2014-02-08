package ohha.replikaatiopeli;

import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
//                Scanner lukija = new Scanner(System.in);
//                Kayttoliittyma kl = new Kayttoliittyma(lukija);
//                kl.kaynnista();
        Vertailija vertailija = new EmasVertailija();
        Emasjarjestys sekvenssi = new Emasjarjestys();
        GraafinenKali kali = new GraafinenKali(vertailija, sekvenssi);
        SwingUtilities.invokeLater(kali);
    }
    
    public static String getPaskaa() {
        return "vitun homot kuolkaa kaikki";
    }
}
