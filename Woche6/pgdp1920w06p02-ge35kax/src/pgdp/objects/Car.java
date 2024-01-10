package pgdp.objects;

public class Car {
	String brand;
	LincesePlate licensePlate;
	int chassisNumber;
	static int count=0;
	
	
	Car(String brand, LincesePlate licensePlate){ //Construktor
		this.brand=brand;
		this.licensePlate=licensePlate;
		this.chassisNumber= count++;// die chassic number= Fahrgestellnummer soll bei jedem neu erzeugten Car-Objekt um eins erhöht werden
		
	}
	public String toString() {
		return "Auto "+ chassisNumber+": Marke"+ brand+ ", Kennzeichen: " +licensePlate;
	}
}
