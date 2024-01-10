package pgdp.math;

public class RabbitPopulation extends MiniJava {

    public static void main(String[] args){
    	int m=1, n,p=4;
  
    	writeConsole("<");
    	n=readInt();
    	write(">"+ n);
    	
    	if(n<1) {
    		write("<Fehler:n>=1 erwartet!");
    	}
    	else {
    		if(n==1) {
    			write(m);
    		}
    		else {
	    		if(n<=3) {
	    			for( int x=2;x <= n; x++ ){
	    				m=2*m;	
	    			}
	    			write(m);
	    		}
	    		else {
	    			for(int x=3; x< n;x++) {
	    				p=2*p -1;
	    			}
	    			write(p);
	    		}
	    		
    		}
    	}
        
    }

}