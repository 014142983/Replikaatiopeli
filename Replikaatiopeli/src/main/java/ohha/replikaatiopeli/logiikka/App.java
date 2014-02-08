package ohha.replikaatiopeli.logiikka;

import ohha.replikaatiopeli.logiikka.EmasVertailija;
import ohha.replikaatiopeli.grafiikka.GraafinenKali;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.domain.Emasjarjestys;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Vertailija vertailija = new EmasVertailija();
        Emasjarjestys sekvenssi = new Emasjarjestys();
        GraafinenKali kali = new GraafinenKali(vertailija, sekvenssi);
        SwingUtilities.invokeLater(kali);
    }
}
