/*package pgdp.crypt;

public class CaesarChiffre extends MiniJava {
    public static void main(String[] args) {
        String inputText = readString("Bitte Text eingeben:");
        int key = readInt("Bitte Schlüssel eingeben:");
        char[]a=new char[inputText.length()];
        a=toArray(inputText);
       
        String resultencr=encrypt(a,key);
        System.out.println(resultencr);
        // TODO output
    }
    
    public static char[] toArray(String input) { //die den übergebenen String in ein Array aus chars umwandelt.
    	
    	char[]result=new char[input.length()];//array length= input length; length-string-name =name.length();**int length() - gibt die Länge eines Strings zurück
    	for(int i=0; i<result.length;i++) {
    		result[i]=input.charAt(i);
    	}
    	return result;
    }
    
    public static String encrypt(char[] input, int key) { //die Verschlüsselung übernimmt
    	 // Die Zahl liegt danach in [-25;25]
        key = key % 26;
        // Die Zahl liegt danach in [1;51]
        key = key + 26;
        // Und jetzt in [0;25]
        key = key % 26;
        char[] encrypted = new char[input.length];
    	for(int i=0;i<input.length;i++) {
    		char current = input[i];
    		if(current >='a'&& current<='z') {
    			current =(char)(((current -'a'+key)%26)+'a');
    			write(input[i]);
    		}
    		
    		else if(input[i]>='A'&& input[i]<='Z') {
    			input[i]=(char)(((input[i]-'A'+key)%26)+'A');
    			write(input[i]);
    		}
    		else {
    			input[i]=input[i];
    			write(input[i]);
    		}
    	}
    	String encr="";
    	for(int i=0;i<input.length;i++) {
    		encr+=ent;
    		System.out.println(encr);
    	}
    	
    	return encr;
    			
    }
    
}*/


package pgdp.crypt;

public class CaesarChiffre extends MiniJava {
    public static void main(String[] args) {
        String inputText = readString("Bitte Text eingeben:");
        int key = readInt("Bitte Schlüssel eingeben:");
        write(encrypt(toArray(inputText), key));
    }

    public static char[] toArray(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < result.length; i++)
            result[i] = input.charAt(i);
        return result;
    }

    public static String encrypt(char[] input, int key) {
        // Die Zahl liegt danach in [-25;25]
        key = key % 26;
        // Die Zahl liegt danach in [1;51]
        key = key + 26;
        // Und jetzt in [0;25]
        key = key % 26;

        char[] encrypted = new char[input.length];// giu nguyen dc day input goc
        for (int i = 0; i < input.length; i++) {
            char current = input[i];
            if (current >= 'a' && current <= 'z') { 
                encrypted[i] = (char) (((current -'a'+ key) % 26) + 'a');
                System.out.println( encrypted[i]);
            }
            else if (current >= 'A' && current <= 'Z')
                encrypted[i] = (char) (((current -'A'+ key) % 26) + 'A');
            else
                encrypted[i] = current;
        }

        return new String(encrypted);
    }
}
