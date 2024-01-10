package pgdp.objects;

public class CarPark {
	Car[] space; //ein Parkhaus mit n Parkplätzen (spaces) repräsentier
	// ???: space duoc khai bao duoi kieu du lieu nao?
	
	//Konstruktor
	CarPark(int n){//ein Parkhaus mit n Parkplätzen (spaces) repräsentier.Dabei soll die Größe n des Parkhauses im Konstruktor übergeben werden.
		this.space= new Car[n];// 
	}
	
	
	//Mehthode
	int Park(Car c) { // car c la gi. c co kieu du lieu la Klasse Car?
		for(int i=0; i<space.length;i++) {
			if(space[i]== null) { // tao sao lai la null, k phai 0
				space[i]=c; //int park(Car c) hinzu, bei der das Car c den ersten freien Parkplatz des Parkhauses belegt. 
				// space i=c co kieu dl trong car
				return i; //die Nummer des belegten Parkplatzes zurückliefern
			}
		}
		return -1; ////Wenn das Parkhaus voll ist, soll -1 zurückgegeben werden.
	}
	
	int search( LincesePlate lp) {
		for(int i=0;i<space.length;i++) {
			if(space[i]!=null && space[i].licensePlate.isEqual(lp)) {
				return i; //Ist das Auto mit dem Nummernschild lp im Parkhaus, soll die Methode die Nummer des Parkplatzes ausgeben
			}
		}
		return -1;
		
	}
	
	Car driveOff( LincesePlate lp) {
		/*for(int i=0;i<space.length;i++) {
			if(space[i].licensePlate.isEqual(lp)) {
				space[i]=null;
				return space[i]; //den vom Auto mit dem Nummernschild lp belegten Parkplatz wieder freigibt und das Auto zurückgibt.
			}
		}
		return null;*/
		
		
		int position=search(lp);
		if(position==-1) {
			return null;
		}
		else {
			
			space[position]=null;
			return space[position];
			//oder so schreiben:
			//Car car = spaces[position];
			//return car
		}
	}
	
	public String toString() {
		//CarPark: Parkhaus:\n und danach <index>: [<car>]\n bzw. <index>: []\n für jeden Platz
			  /*
	         * Diese Methode verwendet einen Stringbuilder.
	         * 
	         * Details dazu gibt es in Aufgabe 04
	         */
	        StringBuilder builder = new StringBuilder();
	        builder.append("Parkhaus:\n");
	        for (int i = 0; i < space.length; i++) {
	            builder.append(i + ": [");
	            if (space[i] != null) {
	                builder.append(space[i]);
	            }
	            builder.append("]\n");
	        }
	        return builder.toString();
	    }
	
}
