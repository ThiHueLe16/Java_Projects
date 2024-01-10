package pgdp.w02.h02;

public class TwoMaximums extends MiniJava {
  public static void main(String[] args) {
    // TODO
	int k, max1, max2,n, n1, n2;
	k=readInt("Bitte Anzahl eingeben:");
	if(k<2) {
		write("Fehler: Anzahl >= 2 erwartet!");
	}
	else {
		n1=readInt("Bitte Zahlen eingeben:");
		n2=readInt("Bitte Zahlen eingeben:");
		if(n1<n2) {
			max1=n2;
			max2=n1;
		}
		else {
			max1=n1;
			max2=n2;
		}
		for(int i =2 ; i<k ;i++) {
			n=readInt("Bitte Zahlen eingeben:");
			if(n>=max1) {
				max2=max1;
				max1=n;	
			}
			else {
				if(n>max2) {
					max2=n;
				}
			}
		}
		write("Erster:");
		write(max1);
		write("Zweiter:");
		write(max2);
	}
  }
}
