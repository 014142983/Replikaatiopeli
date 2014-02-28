package ohha.replikaatiopeli.vaiheyksi.logiikka;

import javax.swing.SwingUtilities;
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
