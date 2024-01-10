package pgdp.collections;

/**
 * Vorgegebene Klasse, hier drin wird nichts bewertet !!!
 * <p>
 * Bitte nicht verändern !!
 */
public class ExceptionUtil {

    /**
     * Use this to end a method or constructor abruptly (by throwing an exception).
     * <p>
     * This signals to the user/developer, that the chosen operation is (currently)
     * not available or supported.
     *
     * @param message the message that the exception contains, choose something that
     *                everyone can understand to help them finding the root of the
     *                problem
     */
    public static void unsupportedOperation(String message) {
        throw new UnsupportedOperationException(message);
    }

    /**
     * Use this to end a method or constructor abruptly (by throwing an exception).
     * <p>
     * This signals to the user/developer, that an argument passed to a method is
     * not a valid parameter value (illegal argument).
     *
     * @param message the message that the exception contains, choose something that
     *                everyone can understand to help them finding the root of the
     *                problem
     */
    public static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }
}
