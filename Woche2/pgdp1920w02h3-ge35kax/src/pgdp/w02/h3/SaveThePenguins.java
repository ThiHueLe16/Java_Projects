package pgdp.w02.h3;

public class SaveThePenguins extends MiniJava {
  public static void main(String[] args) {
	 
    // TODO Save them all!
	int i;
	int t=readInt("Bitte Geben Sie die Anzahl an Zeitschritten ein (>= 1):");
	 if(t>=1) {
		int []Penguin=new int[5]; //{Junge,JungeErwach,Erwach,AlteErwach, Weise};
		Penguin[0]=readInt("Startpopulation Jungtiere"); // Anzahl der Penguin eingeben 
		Penguin[1]=readInt("Startpopulation Junge Erwachsene");
		Penguin[2]=readInt("Startpopulation Erwachsene");
		Penguin[3]=readInt("Startpopulation Alte Erwachsene");
		Penguin[4]=readInt("Startpopulation Weise");
		int EP=Penguin[1]*3+Penguin[2]*2; // EP: Essensportionen
		
		for(int k=1; k<=t;k++) {
			
			for( i=0; i<5; i++) {	
					EP=EP-Penguin[i];	
					if(EP<0) {
						Penguin[i]=Penguin[i]+EP;}
			}
			
			for(int i1=0; i1<5;i1++) {
				if(Penguin[i1]<0) {
					Penguin[i1]=0;
				}
			}	
			
			int []CopyalteZahlPenguin=new int[5];//CopyalteZahlPenguin: Kopieren die alte Anzahl der Penguin 
			
			for(int Copy=0; Copy <5;Copy++) {
				CopyalteZahlPenguin[Copy]=Penguin[Copy];
			}
				
			for(int h=0; h<4;h++) {			//Die Pinguine werden eine Altersstufe älter.
				Penguin[h+1]=CopyalteZahlPenguin[h];	
			}
			
			Penguin[0]=(Penguin[2])/4+(Penguin[3])/2+(Penguin[4])/3; // wie viele neue Junge werden geboren
			
			EP=Penguin[1]*3+Penguin[2]*2; // EP für neue Schleife berechnen.
			
		}
		write("Anzahl Jungtiere:");
		write(Penguin[0]);
		write("Anzahl Junge Erwachsene:");
		write(Penguin[1]);
		write("Anzahl Erwachsene:");
		write(Penguin[2]);
		write("Anzahl Alte Erwachsene:");
		write(Penguin[3]);
		write("Anzahl Weise:");
		write(Penguin[4]);	
	}
	else {
		write("Zeitschritte >= 1 erforderlich");			
	}
  }
}