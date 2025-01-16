package Testare_nr;

import org.example.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testare {

    @Test
    void testAuSumaCifrelorEgala() {
        PerecheNumere pereche1 = new PerecheNumere(123, 321); // Suma cifrelor: 6
        PerecheNumere pereche2 = new PerecheNumere(12, 30);   // Suma cifrelor: 3 și 3
        PerecheNumere pereche3 = new PerecheNumere(14, 25);   // Suma cifrelor: 5 și 7

        assertTrue(pereche1.auSumaCifrelorEgala(), "123 și 321 ar trebui să aibă suma cifrelor egală");
        assertTrue(pereche2.auSumaCifrelorEgala(), "12 și 30 ar trebui să aibă suma cifrelor egală");
        assertFalse(pereche3.auSumaCifrelorEgala(), "14 și 25 nu ar trebui să aibă suma cifrelor egală");
    }
}
