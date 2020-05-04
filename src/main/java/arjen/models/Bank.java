package arjen.models;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Bank deBank = new Bank();
    private Map<String, Rekening> rekeningen = new HashMap<>();

    public static void setBank(Bank bank) {
        Bank.deBank = bank;
    }

    public static Bank getBank() {
        return Bank.deBank;
    }

    private Bank() {
        addRekening(new Rekening("NL04INGB0241998413", "Christopher", 40));
        getRekening("NL04INGB0241998413").stort(93.83);
    }

    public Rekening getRekening(String nummer) {
        return rekeningen.get(nummer);
    }

    public void addRekening(Rekening nieuweRekening) {
        rekeningen.put(nieuweRekening.getNummer(), nieuweRekening);
    }
}
