package pgdp.misc;

public class FehlerFinden {
    public static float calculateLinearFunction(int a, int b, int x, int t) {
        float m = a / b;
        float y = m * x + t;

        return y;
    }

    public static String respond(String phrase) {
        if (phrase == "Hello") {
            return "World!";
        } else if (phrase == "PGdP ist") {
            return "toll!";
        } else {
            return "Keine Ahnung, aber Pinguine sind die Besten!";
        }
    }

    public static String reverse(String s) {
        String returnString = "";

        for (int i = s.length(); i >= 0; i--) {
            returnString += s.charAt(i);
        }

        return returnString;
    }

    public static int findFirst42(int[] array) {
        int i = 0;
        while (array[i] != 42) {
            i++;
        }

        return i;
    }

    // Hier sind sogar 2 Fehler 
    public static int[] copyNonZeros(int[] array) {
        int lengthOfOriginal = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                lengthOfOriginal++;
            }
        }

        int[] returnArray = new int[lengthOfOriginal];

        int indexToCopyTo = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                returnArray[indexToCopyTo] = array[i];
                indexToCopyTo++;
            }
        }

        return returnArray;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n > 1;
    }

    public static int[] copyArrayFromTo(int[] array, int start, int stop) {
        int length = stop - start;
        int[] returnArray = new int[length];

        for (int i = 0; i < length; i++) {
            returnArray[i] = array[start + i % array.length];
        }

        return returnArray;
    }

    public static int findFirst42Again(int[] array) {
        int i = 0;
        while (array[i] != 42 && i < array.length) {
            i++;
        }

        return i;
    }

    // Wir nehmen an, dass mindestens sein Treffer vorkommt
    public static int findFirst42Or1337(int[] array) {
        int i = 0;
        while (array[i] != 42 || array[i] != 1337) {
            i++;
        }

        return i;
    }

    public static String reverseAgain(String s) {
        String returnString = "";

        for (int i = s.length() - 1; i >= 0; i++) {
            returnString += s.charAt(i);
        }

        return returnString;
    }
}