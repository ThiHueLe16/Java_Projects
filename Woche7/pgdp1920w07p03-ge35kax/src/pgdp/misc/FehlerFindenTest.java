package pgdp.misc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FehlerFindenTest {
    @Test
    public void testCalulate() {
        assertTrue("Nicht gefunden", 1.5 == FehlerFinden.calculateLinearFunction(1, 2, 1, 1));
    }

    @Test
    public void testRespond() {
        String x = "";
        x += 'H';
        x += "ello";

        assertTrue("Nicht gefunden", FehlerFinden.respond(x).equals("World!"));
    }

    @Test
    public void testReverse() {
        try {
            FehlerFinden.reverse("a");
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }

    @Test
    public void testFind42() {
        try {
            FehlerFinden.findFirst42(new int[] { 1, 2, 3 });
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }

    @Test
    public void testCopyNonZeros() {
        int[] res = FehlerFinden.copyNonZeros(new int[] { -1, 2, 0 });
        assertTrue("Nicht gefunden", Arrays.equals(res, new int[] { -1, 2 }));
    }

    @Test
    public void testPrime() {
        assertTrue("Nicht gefunden", !FehlerFinden.isPrime(4));
    }

    @Test
    public void testCopyArrayFromTo() {
        try {
            FehlerFinden.copyArrayFromTo(new int[] { 1, 2, 3 }, 5, 4);
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }

    @Test
    public void testFind42Again() {
        try {
            FehlerFinden.findFirst42Again(new int[] { 1, 2, 3 });
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }

    @Test
    public void testFind42Or1337() {
        try {
            assertTrue("Nicht gefunden", FehlerFinden.findFirst42Or1337(new int[] { 1, 2, 42 }) == 2);
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }

    @Test
    public void testReverseAgain() {
        try {
            FehlerFinden.reverseAgain("a");
        } catch (Exception e) {
            fail("Nicht gefunden");
        }
    }
}
