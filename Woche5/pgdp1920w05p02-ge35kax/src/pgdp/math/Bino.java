package pgdp.math;

public class Bino extends MiniJava {
	public static int falkutaet(int a) {
		int fal=1;
		if(a==0) {
			fal=1;
		}
		else {
			for(int i=1;i<a+1;i++) {
				fal *=i;
			}
		}
		return fal;
	}
    public static int bino(int n, int k) {
        // TODO
    	//Loesung 2: benutzen Falkutaet
    	int result;
    	int n1=falkutaet(k)*falkutaet(n-k);
    	result=falkutaet(n)/n1;
        return result;
    }
    
    public static void main(String[] args) {
       int a=5;
       write(falkutaet(15));
       write(falkutaet(10)*falkutaet(5));
       write(bino(15,10));
       
       int n=readInt("n:");
       int k=readInt("k:");
       write(bino(n,k));
       
       
    }
}
