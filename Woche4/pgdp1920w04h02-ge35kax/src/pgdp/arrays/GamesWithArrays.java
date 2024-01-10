package pgdp.arrays;

public class GamesWithArrays {
public static int[]otherSort(int[] arr, int[] arr2) {
    // TODO
	  int igleich=0,iungleich=0, SP=0; //SP zeigt, die aktuellen Position von dem Element in arrNeu
	  int[]arrNeu=new int[arr.length];//Ausgabe
	  int iarr2=0;
	  int count=0;
	  
	  while(SP<arrNeu.length && iarr2<arr2.length) {// Pruefen und geben alle gleiche Werte mit dem Werte von a2 von arr1 in arrNeu ein
		  arrNeu[SP]=arr2[iarr2];
		  for(int i=0;i<arr.length;i++) {//Zaelen die anzahl der gleiche Wert mit aeeNeu
			  if(arr[i]==arrNeu[SP] && SP<arrNeu.length) {
				  igleich=igleich+1;
			  }
		  }
		 if(igleich>1) {
			for(int i1=SP;i1<SP+igleich;i1++) {
				arrNeu[i1]=arr2[iarr2];
			 }
			SP=SP+igleich-1;
		  }
		  SP=SP+1;
		  iarr2=iarr2+1;
		  igleich=0;
	  }
	 
	for(int i2=0;i2<arr2.length;i2++) {
		for(int i3=0;i3<arr.length;i3++) {
				 if(arr[i3]!= arr2[i2]) {
					 for(int i4=0;i4<arr2.length;i4++) {
						 if(arr[i3] !=arr2[i4]) {
							 count=count+1;
						 }
					 }
					 if(count==arr2.length) {
						if(SP<arrNeu.length) {
							arrNeu[SP]=arr[i3];
							SP=SP+1;
						}
					 }
					 count=0;
				}	
		}
	}
	return arrNeu;    
  }

  public static int[] fairFriends(int[] arr, int[] arr2) {
	  //TODO
	  int[]arr3=new int[2];//Ausgabesarray mit der Laenge 2
	  int arr2kopie=0;
	  int arrkopie=0;
	  int sum1=0;// Summe von allen Werten im ersten Array
	  int sum2=0;// Summe von allen Werten in 2.Array
	  
	  for(int a=0; a<arr.length;a++) {//sum1 berechnen
		  sum1=sum1+arr[a];
	  }
	  for(int b=0;b<arr2.length;b++) { //sum2 berechnen
		  sum2=sum2+arr2[b];
	  }
	  if(sum1==sum2) {
		  arr3[0]=0;// in diesem Fall muss nicht mehr tauschen 
		  arr3[1]=0;
	  }
	  else {
		  for(int i1=0; i1< arr.length && sum1!= sum2; i1++) {
			  
			  arr3[0]=arr[i1];
			  for(int i2=0; i2<arr2.length && sum1!=sum2; i2++) {
				  sum1=0;
				  sum2=0;
				  arr3[1]=arr2[i2];
				  arr2kopie=arr2[i2];
				  arrkopie=arr[i1];
				  arr[i1]=arr2kopie; //Tauschen dem Wert
				  arr2[i2]=arrkopie;
				 
				  for(int i3=0; i3<arr.length;i3++) {//sum1 nach dem Tauschen berechnen
					  sum1=sum1+arr[i3];
					 
				  }
				  for(int i4=0;i4<arr2.length;i4++) { //sum2 nach dem Tauschen berechnen
					  sum2=sum2+arr2[i4];
					
					  
				  }
				  arr[i1]=arrkopie;//Bringt dem eingenen Wert zurueck
				  arr2[i2]=arr2kopie;
				  
			  }
		  }
	  }
	  
	  return arr3;
  }

  public static boolean alpen(int[] arr) {
    // TODO
	 int MAX; //max von array
	 MAX =arr[0];
	 int maxPos=0;// die Position, wo Max im arr steht.
	 boolean anschritt=true, abschritt=true;
	 
	 if(arr.length==2) {
		 return false;
	 }
	 else {
		for(int max=0; max<arr.length;max++) {
			if(arr[max]> MAX) {
				MAX=arr[max];
				maxPos=max;
			}
		}
		if(maxPos==0) {
			return false;
		}
		else {
			for(int an=0; an< maxPos && anschritt==true;an++) {
				if(arr[an]<arr[an+1]) {
					anschritt=true;
				}
				else {
					anschritt=false;
				}
			}
			for(int ab=maxPos; ab<arr.length-1 && abschritt==true;ab++) {
				if(arr[ab]>arr[ab+1]) {
					abschritt=true;
				}
				else {
					abschritt=false;
				}
			}
		}
		if( anschritt==true && abschritt==true) {
			return true;
		}
		else {
			return false;
		}
	 }
  }

  public static int[] plankton(int[] arr) {
    // TODO
	  int min=arr[0];
	  int max=arr[0];
	  int h=0;//Kopieren das Wert von i, wo min von diesem array steht.
	  int n1=0;
	  int[]plankton1=new int[3];// ausgeben die Werten von kauf-,verkaufstag, und max.Profit
	  for(int i=0; i< arr.length; i++) { //suchen min-Wert von der array
		  if(min>arr[i] ){
			  min=arr[i];
			  h=i;
		  }
	  }
	  plankton1[0]=min;
	  if(h<arr.length-1) { //suchen max wert von der array
		  max=arr[h+1];
		  for(int n=h+2; n<arr.length;n++) {
		    if(max<arr[n]){
		    	max=arr[n];
		    	n1=n;
		    }
		  }
		  plankton1[0]=h;
		  plankton1[1]=n1;
		  plankton1[2]=max-min;
	  }
	  else {
		  plankton1[0]=0;
			 plankton1[1]=0;
			 plankton1[2]=0;
	  }
	return plankton1;

  }

  public static int pinguinFreunde(int[] arr) {
	  
	
	int[]Menge =new int[arr.length];//die Anzahl der gleiche Wert von jeder Element im Arrays speichern
	  
	 int t=0;
	 int ggT=0	;// die ggT von allen werten von Menge zu berechnen

	 
	 
/*	 for(int b=0; b<arr.length;b++) {// Pruefen jeden Wert von arr mti der Bedingung 0<x<105
		 if(arr[b]<=0 || arr[b]>=100) {
			 return 0; // kiem tra lai
		}
	 }
*/	 for(int n1=0; n1<arr.length;n1++) {
		Menge[n1]=0;
	}
	 
	 for(int n=0; n<arr.length ; n++) { //
			 
			 if(arr[n]!= 1000000) {
				 for(int i=0; i< arr.length ;i++) {
					 if(arr[i]==arr[n]) {
						 Menge[t]=Menge[t]+1;
						 arr[i]=1000000;
						 
					 } 
				 }
				 
				 t=t+1; 
			 }
	 }
	 
	 if(t<arr.length) {
		 for(int b=t; b<arr.length;b++) {
			 Menge[b]=Menge[0];
		 }
	 }
	
		for(int a=0; a<Menge.length-1 ;a++) {
			 
				 if(Menge[a]== Menge[a+1]) {
					 ggT=Menge[a];
				 }
				 else {
					 while(Menge[a]!=Menge[a+1]) {
						 if(Menge[a]>Menge[a+1]) {
							 Menge[a]=Menge[a]-Menge[a+1];
						 }
						 else {
							 Menge[a+1]=Menge[a+1]-Menge[a];
						 }
					 }
					 ggT=Menge[a];
				 }	 
		}
	
	 
	 if(ggT==1) {
		 return 0;
	 }
	 else {
		//return ggT;
		 return ggT;
		 
	 } 
  }
  
  public static void main(String[]args) {
	  int[]arr=new int[] {1,1,2,2,2,2 };
	  int b =pinguinFreunde(arr);
	  System.out.println(b);
	
  }
}

