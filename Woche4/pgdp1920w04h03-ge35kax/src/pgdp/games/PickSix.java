package pgdp.games;

public class PickSix extends MiniJava {
  // sorting method from the lecture
  public static int[] sort(int[] a) {
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; ++i) {
      // begin of insert
      int j = 0;
      while (j < i && a[i] > b[j]) ++j;
      // end of locate
      for (int k = i - 1; k >= j; --k) b[k + 1] = b[k];
      // end of shift
      b[j] = a[i];
      // end of insert
    }
    return b;
  } // end of sort

 

 
  public static void outputStapel(int[][]stapel) {
    // TODO
	  int st3;
	 for(int st=0; st<stapel.length;st++) {
		 st3=st+1;
		 System.out.print("Stapel "+st3+":");
		 for(int st1=0; st1<stapel[st].length;st1++) {
			 if(stapel[st][st1]>0) {
				 System.out.print(" "+stapel[st][st1]);
			 }
		 }
		 System.out.print("\n");
	 }
  }

  public static int playerSelectCard(int player, int[][] playerCards) {
    // TODO
	  
	  /*boolean sgleich=false;//bedingung, damit man eine Schleife auffuehren kann, wenn die eingegebene Zahl nicht gleich mit 1 wert von karte des Spielers
	  int skopie=0;
	  while(sgleich==false) {
		  System.out.print("Spieler "+ player +", du hast die folgenden Karten:");
		  for(int playerS=0; playerS<playerCards[player].length;playerS++) {
			  System.out.print(" "+playerCards[player][playerS]);
		  }
		  System.out.print("\n");
		  int a=readInt("Welche Karte möchtest du ausspielen?");
		  for(int s=0;s<playerCards[player].length;s++) {
			  if(a==playerCards[player][s]) {
				  sgleich=true;
				  skopie=s;
			  }
		  }
	  }*/
	  boolean sgleich=false;
	  int skopie=0;
	  
	  while(sgleich==false){
		  System.out.print("Spieler "+ player +", du hast die folgenden Karten:");
		  for(int playerS=0; playerS<playerCards[player].length;playerS++) {
			  System.out.print(" "+playerCards[player][playerS]);
		  }
		  System.out.print("\n");
		  int a=readInt("Welche Karte möchtest du ausspielen?");
		  for(int s=0;s<playerCards[player].length && sgleich==false;s++) {
			  
			  if(a==playerCards[player][s]) {
				  sgleich=true;
				  playerCards[player][s]=0;
				  skopie=s;
			  }
			  else {
				  sgleich=false;
			  }
		  }
	  }
	  return playerCards[player][skopie];
  }

  public static int calculatePoints(int[] lostCards) {
    // TODO
	  /*int [][]arrCalculate=new int [arrC1][arrC2];
	  int arrC1= drawCardCal();
	  int arrC2=drawCardCal();*/
	  int Kartenwert=0;
	  int Point=0;
	  int Kartewertsumme=0;
	  
	  for(int iPoint=0; iPoint<lostCards.length; iPoint ++) {
		  Point=lostCards[iPoint];//die indizierte Anzahl von dieser Karte
		  Kartenwert=getValueOfCard(Point);// den Wert von jeder Karte
		  Kartewertsumme=Kartewertsumme + Kartenwert;
	  }
	  
	  
     return Kartewertsumme;
  }

  public static void outputResult(int[] playerPoints) {
    // TODO
	  if(playerPoints[0]>playerPoints[1]) {
		  System.out.println("Spieler 2 gewinnt mit "+playerPoints[1]+" gegen Spieler 1 mit "+playerPoints[0]+" Punkten.");
		  
	  }
	  else {
		  if(playerPoints[0]<playerPoints[1]) {
				  System.out.println("Spieler 1 gewinnt mit "+playerPoints[0]+" gegen Spieler 2 mit "+playerPoints[1]+" Punkten.");
		  }
		  else {
			  	System.out.println("Unentschieden! Beide Spieler haben "+ playerPoints[0]+" Punkte.");
		  }
	  }
  }

  public static int getValueOfCard(int card) { //CO PROBLEM VOI %  
    // TODO
	int cardValue=1;//Jede Karte ist mindestens einen Punkt wert, ohne die Karte mit dem Wert 0
	int cardLength=0;
	int count=0;
	int cardkopie=card;//den wert von card kopieren, um cardlength zu berechnen

	
	if (cardkopie<10&& cardkopie> -10) { //Berechnen Cardlength
		cardLength=1;
	}
	else {
		while(cardkopie>10 || cardkopie<-10) {
			cardkopie=cardkopie/10;
			count=count+1;
		}
		cardLength=count+1;
	}//Fertig mit dem Rechnen von cardLength
	
	int[]Zahl=new int[cardLength];// arraz Zahl herstellen, um Wert in jeder Position vpn einem Zahl zu speichern
	int iZahl=0; //index von array Zahl
	boolean igleich=true;// pruefen, ob jede Wert gleich oder nicht
	int igleichcount=0;
	if (card==0){
		cardValue=0;
	}
	else {
			if(card%10 == 0) {
				cardValue=3;
			}
			if(card%10==5) {
				
				cardValue=2;
			}
			/* ob es Schnappzahl code, aber false.wo?
			 * if (card>10 || card<-10){//Suchen den Wert in jeden Stelle von eine Zahl
				while(card != 0) {
					
					if(iZahl<Zahl.length) {
						Zahl[iZahl]=card%10;
						iZahl=iZahl+1;
						card=card/10;
						}
				} 
				for(int ver=1; ver<Zahl.length && igleich==true; ver++) {
					igleich=false;
					if(Zahl[ ver]==Zahl[ver-1]) {
						igleichcount =igleichcount+1;
						igleich=true;
					}
					else {
						igleich=false;
					}
				}
				if(igleichcount == cardLength-1) {
					cardValue=cardValue+5;
				}
			}*/
			if(cardLength==2) {
				if(card%11==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==3) {
				if(card%111==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==4) {
				if(card%1111==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==5) {
				if(card%11111==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==6) {
				if(card%111==111111) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==7) {
				if(card%1111111==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==8) {
				if(card%11111111==0) {
					cardValue=cardValue+5;
				}
			}
			if(cardLength==9) {
				if(card%111111111==0) {
					cardValue=cardValue+5;
				}
			}
	}
	
	return cardValue;
    
}

  public static void givePlayerCards(int[][] playerCards) throws IllegalAccessException {
    // TODO
	  for(int dimen1=0; dimen1<playerCards.length;dimen1++) {
		  for(int dimen2=0; dimen2 <playerCards[dimen1].length; dimen2++) {
			  playerCards[dimen1][dimen2]=drawCard();
			  System.out.println("arr[" + dimen1 + "]["+dimen2+"] =" + " " +playerCards[dimen1][dimen2]);
		  }  
	  }
	  
 }
  
  public static void main(String[] args) throws IllegalAccessException {
	  // TODO
	  int a = getValueOfCard(111);
	  System.out.print(a);
	  int[][]games=new int[2][10];
	  givePlayerCards(games);
	  
	  for(int runde=0;runde<10;runde++) {
		  
	  }
	  
	
  }
 }
