/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

import java.util.Scanner;

/**
 *
 * @author Henri
 */
public class Kayttoliittyma {

    private Emasjarjestys sekvenssi;
    private Scanner lukija;
    private Vertailija vertailija;

    public Kayttoliittyma(Scanner lukija) {
        this.sekvenssi = new Emasjarjestys();
        this.lukija = lukija;
        this.vertailija = new Vertailija();
    }

    public void kaynnista() {
        while (true) {
            System.out.println("Luo lähetti-RNA mallijuosteelle. Korvaa A U:lla, T A:lla, C G:llä ja G C:llä.");
            sekvenssi.luoEmasjarjestys();
            System.out.println(sekvenssi.getPituus());
            System.out.println(sekvenssi.getSekvenssi());
            System.out.println("Syötä juoste: ");
            String lahettiRNA = lukija.nextLine();
            if (vertailija.vertaile(sekvenssi.getSekvenssi(), lahettiRNA)) {
                break;
            } else {
                System.out.println("Syötteesi on virheellinen. Yritä uudestaan.");
            }
        }
        System.out.println("Oikea lähetti-RNA!");
    }
}
