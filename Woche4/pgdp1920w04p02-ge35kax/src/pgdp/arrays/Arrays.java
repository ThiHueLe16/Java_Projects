
package pgdp.arrays;

public class Arrays extends MiniJava {
    public static void print(int[] feld) {
        writeConsole("{");
        if (feld.length > 0) {
            writeConsole(feld[0]);
            for (int i = 1; i < feld.length; i++) {
                writeConsole(", " + feld[i]);
            }
        }
        writeConsole("}");
    }

    public static void minUndMax(int[] feld) {
        if (feld.length == 0) {
            return;
        }
        int min = feld[0];
        int max = feld[0];

        for (int i = 0; i < feld.length; i++) {
            if (feld[i] < min)
                min = feld[i];
            if (feld[i] > max)
                max = feld[i];
        }
        writeConsole("Minimum = " + min + ", Maximum = " + max);
    }

    public static int[] invertieren(int[] feld) {
        int[] invertiert = new int[feld.length];

        for (int i = 0; i < feld.length; i++) {
            invertiert[invertiert.length - 1 - i] = feld[i];
        }

        return invertiert;
    }

    public static int[] schneiden(int[] feld, int laenge) {
        if (laenge <= 0) {
            return new int[0];
        }

        int[] geschnitten = new int[laenge];

        for (int i = 0; i < laenge && i < feld.length; i++) {
            geschnitten[i] = feld[i];
        }

        return geschnitten;
    }

    public static int[] linearisieren(int[][] feld) {
        int laenge = 0;

        for (int i = 0; i < feld.length; i++) {
            laenge = laenge + feld[i].length;
        }

        int[] linearisiert = new int[laenge];
        int linIndex = 0;

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                linearisiert[linIndex++] = feld[i][j];
            }
        }

        return linearisiert;
    }
    public static void main(String[]args) {
    	
    	
    	int[] s=schneiden(new int[] {1, 2, 3}, 2);
    	for(int i=0;i<s.length;i++) {
    		System.out.println(s[i]);
    	}
    	
    	linearisieren(new int[][] {{1, 3}, {25}, {7, 4, 6, 9}});
    }
}
