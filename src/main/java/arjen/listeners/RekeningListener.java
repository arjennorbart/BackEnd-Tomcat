package arjen.listeners;

import arjen.models.Bank;
import arjen.models.Rekening;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RekeningListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");

        Rekening rekening1 = new Rekening("NL88INGB0009635096", "Arjen Norbart", 5);
        Rekening rekening2 = new Rekening("NL60INGB0001535096", "Kees", 20.22);
        Rekening rekening3 = new Rekening("NL70INGB0001212121", "Conjones", 3000.45);
        Rekening rekening4 = new Rekening("NL00INGB0000000000", "Mr. Zero", 500.82);
        Rekening rekening5 = new Rekening("NL69INGB6969696969", "Kama Sutra", 69);

        Bank.getBank().addRekening(rekening1);
        Bank.getBank().addRekening(rekening2);
        Bank.getBank().addRekening(rekening3);
        Bank.getBank().addRekening(rekening4);
        Bank.getBank().addRekening(rekening5);

        rekening1.stort(245); // zou moeten werken. Bedrag zou nu 250 moeten zijn
        rekening3.boekOver(250, rekening1); // bedrag rekening 1 zou nu 500 moeten zijn

        System.out.println("rekeningen aangemaakt + transacties gedaan");

    }
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("applicatie gaat afsluiten");
    }
}
