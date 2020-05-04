package arjen.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private String nummer;
    private String klant;
    private double saldo;

    private List<String> logs = new ArrayList<String>();

    public Rekening(String nummer, String klant, double startSaldo) {
        this.nummer = nummer;
        this.klant = klant;
        this.saldo = startSaldo;
    }

    public String getNummer() {
        log("Rekening nummer opgevraagd");
        return nummer;
    }

    public String getKlant() {
        log("Klantnaam opgevraagd");
        return klant;
    }

    public double getSaldo() {
        log("Saldo opgevraagd");
        return saldo;
    }

    public List<String> getLogs() {
        return logs;
    }

    public void stort(double bedrag) {
        log(String.format("Storting van EUR: %.2f", bedrag));
        saldo += bedrag;
    }

    public void boekOver(double bedrag, Rekening tegenRekening) {
        log(String.format("Overboeking van EUR: %.2f naar %s.", bedrag, tegenRekening.getNummer()));
        this.saldo -= bedrag;
        tegenRekening.stort(bedrag);
    }

    private void log(String log) {
        logs.add(String.format("%s: %s", LocalDateTime.now().toString(), log));
    }
}
