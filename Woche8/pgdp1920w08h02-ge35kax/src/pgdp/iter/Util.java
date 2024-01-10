package pgdp.iter;

import java.util.NoSuchElementException;

/**
 * Verändern Sie diese Klasse nicht.
 */
public class Util {

    public static void noSuchElement(String errorMessage) {
        throw new NoSuchElementException(errorMessage);
    }

    public static void badArgument(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Stellt {@code value} als String mit (mindestens) der Länge
     * {@code length} dar. Falls die Dezimaldarstellung des {@code value} weniger als {@code length}
     * Stellen hat, wird sie mit führenden Nullen aufgefüllt, so dass der String die Länge
     * {@code length} hat. Hat die Dezimaldarstellung von {@code value} bereits {@code length} oder
     * mehr Stellen, so wird diese zurückgegeben.
     *
     * @param value  Der darzustellende Wert
     * @param length Die Länge, zu der die Darstellung aufgefüllt werden soll.
     * @return Die gegebenenfalls mit führenden Nullen aufgefüllte String-Darstellung von
     *         {@code value}
     */
    public static String longToStringWithLength(long value, int length) {
        return String.format("%0" + length + "d", value);
    }

}
