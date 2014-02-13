package ohha.replikaatiopeli.logiikka;

import ohha.replikaatiopeli.logiikka.EmasVertailija;
import ohha.replikaatiopeli.grafiikka.GraafinenKali;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.domain.Emasjarjestys;
import ohha.replikaatiopeli.grafiikka.AloitusIkkuna;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        AloitusIkkuna uusipeli = new AloitusIkkuna();
        SwingUtilities.invokeLater(uusipeli);
    }
}
