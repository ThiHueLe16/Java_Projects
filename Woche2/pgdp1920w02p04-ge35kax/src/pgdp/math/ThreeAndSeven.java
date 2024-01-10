package pgdp.math;

public class ThreeAndSeven extends MiniJava {

    public static void main(String[] args){
    	int n,r1,r2, sum=0; //r1:Rest von der D. durch 3, r2: Rest von der D. durch 7
    	n = readInt();
    	write(">"+n);
    	if(n<0) {
    		write("<Fehler: n>=0 erwatet!");
    	}
    	else {
    		for(int x=1; x<=n;x++) {
    			r1= x%3;
    			r2= x%7;
    			if(r1==0 || r2==0) {
    				sum=sum+x;	
    			}
    		}
    		write("<"+sum);
    	}
    }
}

