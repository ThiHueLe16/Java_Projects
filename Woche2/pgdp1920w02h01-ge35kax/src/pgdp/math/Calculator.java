package pgdp.math;
 
public class Calculator extends MiniJava {
	
    public static void main(String[] args) {
    	//char []operation =new char[]{,+,-,*,/,%};
    	write("Wählen Sie eine Operation:");
    	write("1) +");
    	write("2) -");
    	write("3) *");
    	write("4) /");
    	write("5) %");
    	int n=readInt("6) Programm beenden");
    	
    	while( n!=6 ) {  //n=6 Programm beendet
    		if(n>0 && n<6) {
    			int a=readInt("Ersten Operand eingeben:");
    			
    			int b=readInt("Zweiten Operand eingeben:");
    			
    			switch(n){
    				case 1:
    					write(a+b);
    					break;
    				case 2:
    					write(a-b);
    					break;
    				case 3:
    					write(a*b);
    					break;
    				case 4:
    					if(b==0) {
    						write("Fehler: Division durch 0!");
    					}
    					else {
    						write(a/b);
    					}
    					break;
    				case 5:
    					if(b==0) {
    						write("Fehler: Division durch 0!");
    					}
    					else {
    						write(a%b);
    					}
    					break;	
    			}
    			write("Wählen Sie eine Operation:");
    	    	write("1) +");
    	    	write("2) -");
    	    	write("3) *");
    	    	write("4) /");
    	    	write("5) %");
    	        n=readInt("6) Programm beenden");	
    		}
    		else {
    			write("Wählen Sie eine Operation:");
    	    	write("1) +");
    	    	write("2) -");
    	    	write("3) *");
    	    	write("4) /");
    	    	write("5) %");
    	    	n=readInt("6) Programm beenden");
    		}
    	}
    }		
}
