package pgdp.games;

public class Penguin extends MiniJava {

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
       //TODO
    	for(int i=0;i<world.length;i++){
    		for(int j=0;j<world[i].length;j++) {
    			if( world[i][j]== 0){
    				if(j==world[0].length-1) {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("L(P)\n");
    					}
    					else {
    						writeConsole("L\n");
    					}
    				}
    				else {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("L(P)\t");}
    					else {
    						writeConsole("L\t");
    					}
    				}
    			}
    			
    			if( world[i][j]== 1){
    				if(j==world[0].length-1) {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("E(P)\n");
    					}
    					else {
    						writeConsole("E\n");
    					}
    				}
    				else {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("E(P)\t");}
    					else {
    						writeConsole("E\t");
    					}
    				}
    			}
    			
    			if( world[i][j]== 2){
    				if(j==world[0].length-1) {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("W(P)\n");
    					}
    					else {
    						writeConsole("W\n");
    					}
    				}
    				else {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("W(P)\t");}
    					else {
    						writeConsole("W\t");
    					}
    				}
    			}
    			
    			if( world[i][j]== 3){
    				if(j==world[0].length-1) {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("H(P)\n");
    					}
    					else {
    						writeConsole("H\n");
    					}
    				}
    				else {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("H(P)\t");}
    					else {
    						writeConsole("H\t");
    					}
    				}
    			}
    			
    			if( world[i][j]== 4){
    				if(j==world[0].length-1) {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("F(P)\n");
    					}
    					else {
    						writeConsole("F\n");
    					}
    				}
    				else {
    					if(j==pinguColumn && i==pinguRow) {
    						writeConsole("F(P)\t");}
    					else {
    						writeConsole("F\t");
    					}
    				}
    			}
    			
    		}
    	}	
    }
    public static int Wurzel(int n) {
    
    	int x, t;
    	t = 1;
    	x = (n / 2) + 1;
    	while (t != 0) {
    	    t = ((n / x) + x) / 2;
    	    if (x - t > 1)
    	        x = t;
    	    else {
    	        x = x - 2;
    	        if (t * t <= n)
    	            x = t;
    	        t = 0;
    	    }
    	}
    	return x;
    }
    
    
    
    
    
    

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn){
        //TODO
    	 boolean result=false;
       
         int[][] directionsL = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; //alle Richtungsmoeglichkeit von einem Feld
     	 int[][]directionsE= new int[][]{ {-1,-1},{1,1},{1,-1},{-1,1}};
     	 int[][]directionsW=new int[][]{{-3,-3},{3,3},{3,-3},{-3,3}};
     	 int maxX= world[0].length;
     	 int maxY= world.length;
     
     	 
     	 //Beginn
         if(world[pinguRow][pinguColumn]==3 || world[pinguRow][pinguColumn]<0 ) {//Endfeld.
        	 result= false;
         }
         if(world[pinguRow][pinguColumn]==4) {
        	 result=true;
         }
         
    	 if(world[pinguRow][pinguColumn]==0) {//Pingu steht auf der Landflaeche
    		 world[pinguRow][pinguColumn]= -5; // OLD.PATH.AKTIV
    		
    		 for(int i=0; i<directionsL.length ;i++) { //Rekursiv der weiter moegliche gehende Richtung 
 					if(pinguRow+directionsL[i][0]<maxY && pinguRow+directionsL[i][0]>=0 && pinguColumn+directionsL[i][1]<maxX && pinguColumn+directionsL[i][1]>=0  ){
 						if(world[pinguRow+directionsL[i][0]][pinguColumn+directionsL[i][1]]!=3 && world[pinguRow+directionsL[i][0]][pinguColumn+directionsL[i][1]] >=0) {
 							
		 					result=isFishReachable( world, pinguRow+directionsL[i][0],pinguColumn+directionsL[i][1]);
		 					if(result) {
		 						
		 						write(pinguRow+" " +pinguColumn+"");
		 						return true;
		 					}
 						}
 					}
 			 }
    		// return result;
    	 }
    	 
    	 if(world[pinguRow][pinguColumn]==1) {//Pingu steht auf der Eisflaeche
    		 world[pinguRow][pinguColumn]= -5; // OLD.PATH.AKTIV
    		 for(int i=0; i<directionsE.length ;i++) { //Rekursiv der weiter moegliche gehende Richtung 
 					if((pinguRow+directionsE[i][0]<maxY) &&(pinguRow+directionsE[i][0])>=0 && (pinguColumn+directionsE[i][1])<maxX && (pinguColumn+directionsE[i][1])>=0  ) {
 						
 						if(world[pinguRow+directionsE[i][0]][pinguColumn+directionsE[i][1]] !=3 && world[pinguRow+directionsE[i][0]][pinguColumn+directionsE[i][1]] >=0) {
 				
 							
	 						result=isFishReachable( world, pinguRow+directionsE[i][0],pinguColumn+directionsE[i][1]);
	 						if(result) {
		 						write(pinguRow+" " +pinguColumn+"");
	 							return true;
	 							
	 						}
 						}	
 					}
    		}
    		//return result;
    	 }
    	 
    	 if(world[pinguRow][pinguColumn]==2) {//Pingu steht auf der Eisflaeche
    		 world[pinguRow][pinguColumn]= -5; // OLD.PATH.AKTIV
    		 
    		 for(int i=0; i<directionsW.length ; i++) { //Rekursiv der weiter moegliche gehende Richtung 
 					
 					if(pinguRow+directionsW[i][0]<maxY && pinguRow+directionsW[i][0]>=0 && pinguColumn+directionsW[i][1]<maxX && pinguColumn+directionsW[i][1]>=0) {
 						if( world[pinguRow+directionsW[i][0]][pinguColumn+directionsW[i][1]]!=3 && world[pinguRow+directionsW[i][0]][pinguColumn+directionsW[i][1]] >=0){
 							
	 						result=isFishReachable( world, pinguRow+directionsW[i][0],pinguColumn+directionsW[i][1]);
	 						if(result) {
		 						write(pinguRow+" " +pinguColumn+"");
	 							return true;
	 						}
 						}
 					
 					}	
    		 }
    		//return result;
    	 }
    	 
    	 return result;
    }
    
    	/*int maxX= world[0].length;
    	int maxY= world.length;
    	int maxDiagonale=Wurzel(maxX*maxX+ maxY*maxY);
    	int w1=0;// w1=pinguRow*pinguRow+pinguColumn*pinguColumn
    	boolean wege=true;
    	int[][] directionsL = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; //alle Richtungsmoeglichkeit von einem Feld
    	int[][]directionsE= new int[][]{ {-1,-1},{1,1},{1,-1},{-1,1}};
    	int[][]directionsW=new int[][]{{-3,-3},{3,3},{3,-3},{-3,3}};
        int[][] count=new int[world.length][world[0].length];
        for(int i=0;i<world.length;i++) {//Am Anfang werden alle Element von count mit 0 inialisiert
        	for(int j=0;j<world[0].length;j++) {
        		count[i][j]=0;
        	}
        }
        int[][]worldKopie=new int[world.length][world[0].length];
        worldKopie=world;
        int pinguRowkopie=pinguRow;// kopie Wert, bevor es geaendert wird
		int pinguColumnkopie=pinguColumn;
		int feld=0; //anzahl der Feld=-1
        int feldmax=world.length*world[0].length;
        //Beginn
        while(world[pinguRow][pinguColumn] != 3 && world[pinguRow][pinguColumn] !=4 && feld!=feldmax) {
        	if(count[pinguRow][pinguColumn]<4 || (world[pinguRow][pinguColumn]==-1 && wege==true)||(count[pinguRow][pinguColumn]==4 &&wege==true)) {
        		wege=false;
        		if(world[pinguRow][pinguColumn]==0) { //Pingu steht auf der Landflaeche
        			world[pinguRow][pinguColumn]= -world[pinguRow][pinguColumn]; // OLD.PATH.AKTIV,dieses Feld wird nicht mehr in der Rekursiv benutz
        			for(int i=0; i<directionsL.length && wege==false;i++) { //Rekursiv der weiter moegliche gehende Richtung 
    					wege =true;
    					if(directionsL[i][0]!=0 &&directionsL[i][1]!=0) {
	    					++count[pinguRow][pinguColumn];
	    					pinguRowkopie=pinguRow;
	    					pinguColumnkopie=pinguColumn;
	    					pinguRow +=directionsL[i][0];
	    					pinguColumn += directionsL[i][1];
	    					if(pinguRow<maxX && pinguRow>=0 && pinguColumn<maxY && pinguRow>=0 && world[pinguRow][pinguColumn]!=3 && world[pinguRow][pinguColumn]>0) {//neue Potion von pingu ist moeglich
	    						wege=true;
	    						directionsL[i][0]=0;
	        					directionsL[i][1]=0;
	    					}
	    					else {
	    						wege=false;
	    						directionsL[i][0]=0;
	        					directionsL[i][1]=0;
	    						pinguRow=pinguRowkopie;
	    						pinguColumn=pinguColumnkopie;
	    					}
        				}	
    					else {
    						wege=false;
    						
    					}
        			}
        		}
        		
        		if(world[pinguRow][pinguColumn]==1) { //Pingu steht auf der Eisflaeche
        			world[pinguRow][pinguColumn]= -world[pinguRow][pinguColumn]; // OLD.PATH.AKTIV,dieses Feld wird nicht mehr in der Rekursiv benutz
        			for(int i=0; i<directionsE.length && wege==false;i++) { //Rekursiv der weiter moegliche gehende Richtung 
    					wege =true;
    					if(directionsE[i][0]!=0 &&directionsE[i][1]!=0) {
	    					++count[pinguRow][pinguColumn];
	    					pinguRowkopie=pinguRow;
	    					pinguColumnkopie=pinguColumn;
	    					pinguRow +=directionsE[i][0];
	    					pinguColumn += directionsE[i][1];
	    					w1=pinguRow*pinguRow+pinguColumn*pinguColumn;
	    					if(pinguRow<maxX && pinguRow>=0 && pinguColumn<maxY && pinguRow>=0 && world[pinguRow][pinguColumn]!=3 && world[pinguRow][pinguColumn]>0 &&Wurzel(w1)>=0 && Wurzel(w1)<maxDiagonale) {//neue Potion von pingu ist moeglich
	    						wege=true;
	    						directionsE[i][0]=0;
	        					directionsE[i][1]=0;
	    					}
	    					else {
	    						directionsE[i][0]=0;
	        					directionsE[i][1]=0;
	    						wege=false;
	    						pinguRow=pinguRowkopie;
	    						pinguColumn=pinguColumnkopie;
	    					}
        				}	
    					else {
    						wege=false;
    					}
        			}
        		}
        		
        		if(world[pinguRow][pinguColumn]==2) { //Pingu steht auf der Wasserflaeche
        			world[pinguRow][pinguColumn]= -world[pinguRow][pinguColumn]; // OLD.PATH.AKTIV,dieses Feld wird nicht mehr in der Rekursiv benutz
        			for(int i=0; i<directionsW.length && wege==false;i++) { //Rekursiv der weiter moegliche gehende Richtung 
    					wege =true;
    					if(directionsW[i][0]!=0 &&directionsW[i][1]!=0) {
	    					count[pinguRow][pinguColumn]=count[pinguRow][pinguColumn]+1;
	    					pinguRowkopie=pinguRow;
	    					pinguColumnkopie=pinguColumn;
	    					pinguRow +=directionsW[i][0];
	    					pinguColumn += directionsW[i][1];
	    					w1=pinguRow*pinguRow+pinguColumn*pinguColumn;
	    					if(pinguRow<maxX && pinguRow>=0 && pinguColumn<maxY && pinguRow>=0 && world[pinguRow][pinguColumn]!=3 && world[pinguRow][pinguColumn] >0 &&Wurzel(w1)>=0 && Wurzel(w1)<maxDiagonale) {//neue Potion von pingu ist moeglich
	    						wege=true;
	    						directionsW[i][0]=0;
	        					directionsW[i][1]=0;
	    					}
	    					else {
	    						wege=false;
	    						directionsW[i][0]=0;
	        					directionsW[i][1]=0;
	    						pinguRow=pinguRowkopie;
	    						pinguColumn=pinguColumnkopie;
	    					}
        				}	
    					else {
    						wege=false;
    					}
        			}
        		}
        		
        	}
        	else {
        		world[pinguRow][pinguColumn]=-1;//OLD.path.done,dieses Feld wird nicht mehr benutz
    			
    			pinguRow=pinguRowkopie;// wenn diese Feld nicht mehr moeglich zu nutzen, dann kommt zurueck zu der letzten Feld
    			pinguColumn=pinguColumnkopie;
    			world[pinguRow][pinguColumn]=worldKopie[pinguRow][pinguColumn];
        	}
        	
        	for(int i=0; i<world.length;i++) {
        		for(int j=0;j<world[0].length;j++) {
        			if(world[i][j]==-1) {
        				feld=feld+1;
        			}
        		}
        	}
        	
        }
        
        //Ausgeben
        if(world[pinguRow][pinguColumn]==4) {
        	return true;
        }
        else {
        	return false;
        }
			
    }*/
       

    /**
     * Gibt die Beispielwelt Nr. 1 zurück.
     * Modifizieren Sie diese Methode nicht.
     * @return Eine Beispielwelt
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};	
    }

    /**
     * Gibt die Beispielwelt Nr. 2 zurück.
     * Modifizieren Sie diese Methode nicht.
     * @return Eine Beispielwelt
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /** 
     *  Sie können die main-Methode verwenden, um Ihr Programm zu testen. 
     */
    public static void main(String[] args){
    	
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        for(int i=0;i<world.length;i++) {
        	for(int j=0;j<world[0].length;j++) {
        		System.out.print(world[i][j]+" ");
        	}
        	write("");
        }
        printWorld(world,pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
        for(int i=0;i<world.length;i++) {
        	for(int j=0;j<world[0].length;j++){
        		System.out.print(world[i][j]+" ");
        	}
        	write("");
        }
    
    }
    
}
