package pgdp.objects;

public class LincesePlate {
	String regionalCode;
	String letters;
	int digits;
	
	
	
	//konstruktor
	LincesePlate(String regionalCode, String letters, int digits){ 
		this.regionalCode=regionalCode;
		this.letters=letters;
		this.digits=digits;
	}
	
	//Methode
	boolean isEqual( LincesePlate other) {// true zurückgibt, wenn other und this das gleiche Nummernschild beschreiben.
		return regionalCode.equals(other.regionalCode) && letters.equals(other.letters)&& digits==other.digits;
	}
	
	//Methode
	public String toString() {
		return regionalCode+":"+letters+" "+digits;
	}
	
}
