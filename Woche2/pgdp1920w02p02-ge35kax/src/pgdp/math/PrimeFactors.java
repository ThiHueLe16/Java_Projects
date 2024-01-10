package pgdp.math;

public class PrimeFactors extends MiniJava {

    public static void main(String[] args){
    	
    	int x,y,E,R; // E=Ergebnis; R=Rest; y=Zaeler
    	y=2; 
    	
    	writeConsole("<"); 
    	x=readInt("Bitte Zahl eingeben:");
    	if(x<y) {
    		write("<Fehler:x>1 erwartet!");
    	}
    	else{
	    	write(">"+x);
	    	R=x%y;
	    	E=x/y;
	    	writeConsole("<");
	    	while(x>=y) {
		    	if(R==0) {
		    	
		    		writeConsole( y+" ");
		    		x=E;
		    		R=x%y;
		    		E=x/y;
		    	}
		    	
		    	else {
		    		y=y+1;
		    		R=x%y;
		    		E=x/y;
		    	}
	    	}
		    
    	}
    }
}
