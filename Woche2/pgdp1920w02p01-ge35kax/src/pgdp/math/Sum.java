package pgdp.math;

public class Sum extends MiniJava{

    public static void main(String[] args){
    	int n,Summe;
    	n=readInt("Bitte Zahl eingeben:");
    	Summe=n;
    	while(n!=0) {
    		n=readInt("Bitte Zahl eingeben:");
    		Summe=Summe+n;
    	}
    	write("Summe:");
    	write(Summe);

    }
}