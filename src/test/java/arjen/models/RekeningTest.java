package arjen.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RekeningTest {
    @Test
    public void testStortPositiefBedrag() {
        Rekening testRekening = new Rekening("1", "test", 5);
        testRekening.stort(20);
        assertEquals(25, testRekening.getSaldo(), "Iets niet goed gegaan met storten");
    }

    @Test
    public void testStortNegatiefBedrag() {
        Rekening testRekening = new Rekening("1", "test", 5);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> testRekening.stort(-10), "Moet fout gooien want kan geen negatief bedrag storten");
        assertTrue(thrown.getMessage().contains("Kan alleen een positief bedgrag storten"));
    }

    @Test
    public void testStortNulEuro() {
        Rekening testRekening = new Rekening("1", "test", 5);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> testRekening.stort(0), "Moet fout gooien want kan geen negatief bedrag storten");
        assertTrue(thrown.getMessage().contains("Kan alleen een positief bedgrag storten"));
    }

    @Test
    public void testBoekOverGeldigBedrag() {
        Rekening testRekening1 = new Rekening("1", "test1", 5);
        Rekening testRekening2 = new Rekening("2", "test2", 5);
        testRekening1.boekOver(2, testRekening2);
        assertEquals(3, testRekening1.getSaldo(), "Nieuwe saldo zou 3 euro moeten zijn");
        assertEquals(7, testRekening2.getSaldo(), "Nieuwe saldo zou 7 euro moeten zijn");
    }

    @Test
    public void testBoekOverNegatiefBedrag() {
        Rekening testRekening1 = new Rekening("1", "test1", 5);
        Rekening testRekening2 = new Rekening("2", "test2", 5);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> testRekening1.boekOver(-10, testRekening2), "Moet fout gooien want kan geen negatief bedrag overmaken");
        assertTrue(thrown.getMessage().contains("Kan niet rood staan, max over te boeken bedrag is"));
    }

    @Test
    public void testBoekOverNulEuro() {
        Rekening testRekening1 = new Rekening("1", "test1", 5);
        Rekening testRekening2 = new Rekening("2", "test2", 5);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> testRekening1.boekOver(0, testRekening2), "Kan geen 0 euro overmaken");
        assertTrue(thrown.getMessage().contains("Kan niet rood staan, max over te boeken bedrag is"));
    }

    @Test
    public void testBoekOverSaldoTeLaag() {
        Rekening testRekening1 = new Rekening("1", "test1", 5);
        Rekening testRekening2 = new Rekening("2", "test2", 5);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> testRekening1.boekOver(10, testRekening2), "Moet fout gooien want saldo is te laag");
        assertTrue(thrown.getMessage().contains("Kan niet rood staan, max over te boeken bedrag is"));
    }
}
