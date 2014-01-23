package ohha.replikaatiopeli;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kl = new Kayttoliittyma(lukija);
        kl.kaynnista();
    }
}
