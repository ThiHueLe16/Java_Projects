 package pgdp.w03.h03;
public class ShutTheBox extends MiniJava {
  public static void main(String[] args) throws IllegalAccessException {
    boolean[] boxes = {true, true, true, true, true, true, true, true};
    // TODO

    
    int w1,w2, sum;//w1, w2: gewuerferte Zahl; sum: Summe der gewuerfelten Augenzahlen
    
    int []Punktekonto=new int[2];
    Punktekonto[0]=0;
    Punktekonto[1]=0;
    int n_alt=0; //Kopieren der Wert von der RundeZahl
    int i_alt=0; //Kopieren den Wert von der Spielerzahl, damit wir wissen, ob Spieler1 oder Spieler2 gerade spielt
    int zahl1,zahl2;
   
    int sumZahl=0;// summe der eingegebenen Zahlen von Spielern;
    
   
    boolean wiederholen=true;
    
    int openboxZahl=0;
    
    for(int h=0; h<8;h++) { //die Summe der noch geoeffneten Boxen 
		if(boxes[h]==true) {
			openboxZahl = openboxZahl +h+1;
		}
    }
    //BEGINNEN
    for( int n=1; n<9 && openboxZahl !=0 ;n++ ){ //Beginnen der Runde von 1 bis 8
    	
    	for(int i=1;i<3 && wiederholen==true;i++) {
    		write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:");
    		w1=dice();
    		w2=dice();
    		write(w1);
    		write(w2);
    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
    		outputBoxes(boxes); // geöffnete Boxen ausgeben 
    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
    		zahl1=readInt("Box 1:");
    		zahl2=readInt("Box 2:");
    		
    		sumZahl=zahl1 +zahl2;
    		
    		while(wiederholen ==true) { // Pruefen der eingegebenen Zahlen
    			wiederholen=false;
    			
    			
    			if((zahl1 >8 || zahl1 <0)||(zahl2>8||zahl2<0)||((zahl1>8 || zahl1 <0)&&(zahl2>8||zahl2<0))) {
    				Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
    				write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:");
		    		write(w1);
		    		write(w2);
		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    		outputBoxes(boxes); 
		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    		zahl1=readInt("Box 1:");
		    		zahl2=readInt("Box 2:");
		    		
		    		sumZahl=zahl1 +zahl2;
		    		wiederholen=true;
    			}
    			else {
    			
    			
    			
		    			if(zahl1 == zahl2) {
		    				if(zahl1==zahl2 && zahl1==0 && zahl2==0) {
		    					Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
		    				}
		    				else if(boxes[zahl1-1]==true) {
		    					write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:");
		    		    		write(w1);
		    		    		write(w2);
		    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    		    		outputBoxes(boxes); 
		    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    		    		zahl1=readInt("Box 1:");
		    		    		zahl2=readInt("Box 2:");
		    		    		
		    		    		sumZahl=zahl1 +zahl2;
		    		    		wiederholen=true;
		    				}
		    				else {
		    					Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
		    					write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:");
		    		    		write(w1);
		    		    		write(w2);
		    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    		    		outputBoxes(boxes); 
		    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    		    		zahl1=readInt("Box 1:");
		    		    		zahl2=readInt("Box 2:");
		    		    		sumZahl=zahl1 +zahl2;
		    		    		wiederholen=true;
		    				}
		    			}
		    			else {
		    				if(zahl1!= zahl2 &&(zahl1==0||zahl2==0)) {
		    					Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
		    					write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:"); //Nochmal eingeben
		    		    		write(w1);
		    		    		write(w2);
		    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    		    		outputBoxes(boxes); 
		    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    		    		zahl1=readInt("Box 1:");
		    		    		zahl2=readInt("Box 2:");
		    		    		sumZahl=zahl1 +zahl2;
		    		    		wiederholen=true;
		    					
		    				}
		    				else { //beide eingegebene Zahlen sind nicht gleich, und nicht gleich 0
		    					if(sum==sumZahl) {
		    						if(boxes[zahl1-1]==true && boxes[zahl2-1]==true) { // alle Regel erfuellt
		    							boxes[zahl1-1]=false;
		    							boxes[zahl2-1]=false;
		    							openboxZahl=openboxZahl-zahl1-zahl2;
		    						}
		    						else { // sum=sumzahl, aber mindesten eine eingegebene Zahl ist die Nummer von dem geschlossenen Box
		    							Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
		    	    					write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:"); //Nochmal eingeben
		    	    		    		write(w1);
		    	    		    		write(w2);
		    	    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    	    		    		outputBoxes(boxes); 
		    	    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    	    		    		zahl1=readInt("Box 1:");
		    	    		    		zahl2=readInt("Box 2:");
		    	    		    		sumZahl=zahl1 +zahl2;
		    	    		    		wiederholen=true;
		    						}
		    					}
		    					else { // Fall: sumZahl ist ungleich summe der gewuerfelten Augenzahlen, sumZahl!=sum
		    						if(boxes[zahl1-1]==true && boxes[zahl2-1]==true) { //Fall, sumZahl!=sum, aber die gewaelten Boxen sind die noch geoeffneten Boxen
		    							write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:"); //Nochmal eingeben
		    	    		    		write(w1);
		    	    		    		write(w2);
		    	    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    	    		    		outputBoxes(boxes); 
		    	    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    	    		    		zahl1=readInt("Box 1:");
		    	    		    		zahl2=readInt("Box 2:");
		    	    		    		sumZahl=zahl1 +zahl2;
		    	    		    		wiederholen=true;
		    						}
		    						else {
		    							Punktekonto[i-1]=Punktekonto[i-1]+openboxZahl;
		    	    					write("Spieler "+ i+" hat die folgenden Zahlen gewürfelt:"); //Nochmal eingeben
		    	    		    		write(w1);
		    	    		    		write(w2);
		    	    		    		sum=w1+w2;//sum: Summe der gewuerfelten Augenzahlen
		    	    		    		outputBoxes(boxes); 
		    	    		    		write("Welche Boxen möchte Spieler "+i+" schliessen? (0 für keine valide Kombination)");
		    	    		    		zahl1=readInt("Box 1:");
		    	    		    		zahl2=readInt("Box 2:");
		    	    		    		sumZahl=zahl1 +zahl2;
		    	    		    		wiederholen=true;
		    							
		    						}
		    					}
		    				}
		    			}
    			}
    		}
    		i_alt=i;
    		wiederholen=true;
    		
    	}
    	n_alt=n;
    	
    }
    
   
    //Ausgeben der Spieler, der diese Spiele gewonnen hat
   	if(n_alt==8) {
   		write("Spieler 1 Punktzahl");
   		write(Punktekonto[0]);
   		write("Spieler 2 Punktzahl");
   		write(Punktekonto[1]);
   		if(Punktekonto[0]>Punktekonto[1]) {
   			
   			write("Spieler 2 gewinnt!");
   		}
   		else if(Punktekonto[1]==Punktekonto[0]) {
   			write("Beide gewinnen!");
   		}
   		else {
   			write("Spieler 1 gewinnt!");
   		}
   	}
   	else {
   		write("Spieler "+i_alt+" schliesst alle Boxen! Spieler " +i_alt+" gewinnt!");

    }
  }

  /**
   * Do not modify this !
   * @param boxes
   */
  private static void outputBoxes(boolean[] boxes) {
    StringBuilder sb = new StringBuilder("Geöffnete Boxen: 1:");
    sb.append(boxes[0]);
    for (int i = 1; i < boxes.length; i++) {
      sb.append(" ").append(i + 1).append(":").append(boxes[i]);
    }
    write(sb.toString());
  }
}