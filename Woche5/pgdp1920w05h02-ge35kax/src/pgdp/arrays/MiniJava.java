package pgdp.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MiniJava {
  private static InputStream is = System.in;
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

  private static Random rand = null;

  public static String readString(String text) {
    // Exchange the reader in case System.in has changed.
    // This is necessary for testing, as for every test input, System.in is changed.
    // TODO: Consider whether a better solution is possible with mocking/a different InputStream implementation
    // on the test side.
    if (System.in != is) {
      is = System.in;
      bufferedReader = new BufferedReader(new InputStreamReader(is));
    }
    try{
        System.out.println(text);
        return bufferedReader.readLine();
    } catch (IOException e) {
        // We "hide" the exception in the method signature by rethrowing an unchecked exception
        throw new RuntimeException("Konnte Eingabe nicht lesen.");
    }
  }

  public static String readString() {
    return readString("Eingabe:");
  }

  public static int readInt(String text) {
    String s = readString(text);

    int x;
    if (s == null)
      System.exit(0);
    try {
      x = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      x = readInt(text);
    }
    return x;
  }

  public static int readInt() {
    return readInt("Geben Sie eine ganze Zahl ein:");
  }

  public static int read(String text) {
    return readInt(text);
  }

  public static int read() {
    return readInt();
  }

  public static double readDouble(String text) {
    String s = readString(text);

    double x;
    if (s == null)
      System.exit(0);
    try {
      x = Double.parseDouble(s.trim());
    } catch (NumberFormatException e) {
      x = readDouble(text);
    }
    return x;
  }

  public static double readDouble() {
    return readDouble("Geben Sie eine Zahl ein:");
  }

  public static void write(String output) {
    System.out.println(output);
  }

  public static void write(int output) {
    write("" + output);
  }

  public static void write(double output) {
    write("" + output);
  }

  public static void write(long output) {
    write("" + output);
  }

  public static void writeLineConsole(String output) {
    System.out.println(output);
  }

  public static void writeLineConsole(int output) {
    writeLineConsole("" + output);
  }

  public static void writeLineConsole(double output) {
    writeLineConsole("" + output);
  }

  public static void writeLineConsole(long output) {
    writeLineConsole("" + output);
  }
  
  public static void writeLineConsole() {
    writeLineConsole("");
  }
  
  public static void writeConsole(String output) {
    System.out.print(output);
  }

  public static void writeConsole(int output) {
    writeConsole("" + output);
  }

  public static void writeConsole(double output) {
    writeConsole("" + output);
  }

  public static void writeConsole(long output) {
    writeConsole("" + output);
  }

  public static void resetRandom() {
    rand = null;
  }

  public static void setRandomWithSeed(int seed) throws IllegalAccessException {
    if (rand != null) {
      throw new IllegalAccessException("Don't touch this");
    }
    rand = new Random(seed);
  }

  public static void setRandom() throws IllegalAccessException {
    setRandomWithSeed(144);
  }

  public static int randomInt(int minval, int maxval) {
    return minval + rand.nextInt(maxval - minval + 1);
  }

  public static int drawCard() throws IllegalAccessException {
    if (rand == null) {
      setRandom();
    }

    return randomInt(1, 105);
  }

  public static int dice() throws IllegalAccessException {
    if (rand == null) {
      setRandom();
    }
    return randomInt(1, 6);
  }

}