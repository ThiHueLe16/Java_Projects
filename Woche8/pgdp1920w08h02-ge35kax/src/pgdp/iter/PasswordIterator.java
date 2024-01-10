package pgdp.iter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PasswordIterator implements Iterator<String> {
	private int passwortLength;
	public int getPasslaenge() {
		return this.passwortLength;
	}
	private static long itera;
	private long max;
	private long schritt;
	private long schrittAuf;
	private long schrittAb;
	
	
	static long  count;
	static long  countKopie;
	static long zahl;
	static long countAuf;
	static long countAb;
	static long countAufFall4;
	static long countAbFall4;
	static long countBeliebig;// im 4.Fall benutzt werden 
	static boolean check;
	
	
	
	
    public PasswordIterator(int passwordLength) {
        // TODO
    	
    	
    	
    	if(passwordLength<1 || passwordLength>9) 
    		Util.badArgument("der übergebene Wert ist kleiner als 1 oder größer als 9");
    	else {
    		this.passwortLength=passwordLength;
    		count=0;
    		itera=0;
    		 max=0;
    		 schritt=0;
    		 schrittAuf=0;
    		 schrittAb=0;
    		 countKopie=0;
    		 zahl=0;
    		 countAuf=0;
    		 countAufFall4=0;
    		 countAb=10-passwortLength;
    		 countAbFall4=10-passwortLength;
    		 countBeliebig=0;
    		 check=true;
    		 
    		for(int i=0;i<passwortLength;i++) {
    		    	schritt=schritt*10+1; 
    		    	//System.out.println("schritt"+schritt);
    		} 
    		
    		for(int i=0;i<passwortLength;i++) {
		    	schrittAuf=schrittAuf*10+i;
    		}
    		
    		 
    		 for(int i=0;i<passwortLength;i++) {
 		    	schrittAb=schrittAb*10+(9-i);
 		    	//System.out.println("ab"+schrittAb);
     		}
    		 for(int i=1;i<=passwortLength;i++) {
  		    	max=max*10+9;
  		    	//System.out.println("max"+max);
  		    	
      		}
    		 
    	}
    	
    }
   
   
   
    public boolean hasNext() {
        if(count<=max) {
        	return true;
        }
        return false;
    }

    public String next() {
        // TODO
    	if(passwortLength==1) {
    		if(count <=max) {
    			itera=schritt*count;
    			count++;
    			return Util.longToStringWithLength(itera,passwortLength);
    		}
    		else {
    			Util.noSuchElement("Es gibt kein Element mehr");
    			return null;
    		}
    	}
    	else { //PasswortLength>=2
    		if(count<=max) { //Bedingung: um eine Itera auszugeben
	    		if(count <=9) {// Ausgabe der 1.Fall: alle Element sind gleich
	    			itera=schritt*count;
	    			count++;
	    			return Util.longToStringWithLength(itera,passwortLength);
	    			
	    		}
	    		else {
	    			if(countAuf<=10-passwortLength && count<=max)  {
	    				itera=countAuf*schritt+schrittAuf;
	        			count++;
	        			countAuf++;
	        			//return Util.longToStringWithLength(itera-schritt,passwortLength);
	        			return Util.longToStringWithLength(itera,passwortLength);
	    			}
	    			else {
	    				if(countAb>=0 && count<=max) { // die naechste Elemente immer als 1 kleiner 
	    					itera=schrittAb-countAb*schritt;
	            			count++;
	            			countAb--;
	            			return Util.longToStringWithLength(itera,passwortLength);
	    				}
	    				else {
	    					while(check && count<=max && countBeliebig<=max) {
	    						check=false; 
		    					itera=countBeliebig;
		    					countBeliebig++;
		    					if(itera%schritt==0) {
		    						check=true;
		    					}
		    					else {
		    						//if((itera-schrittAuf)%schritt==0 && check==false && (itera!=(10-passwortLength)*schritt+schrittAuf)) {
		    						if((itera-schrittAuf)%schritt==0 && check==false && countAufFall4<=10-passwortLength) {
		    							countAufFall4++;
		    							check=true;
		    						}
		    						if((itera-schrittAb)%schritt==0 && check==false && countAbFall4>=0) {
		    							check=true;
		    							countAbFall4--;
		    						}
	    					
		    					}
	    					}
	    					check=true;
	    					count++;
	    					return Util.longToStringWithLength(itera,passwortLength);
	    				}
	    			}
	    		}
    		}
    		else {
    			Util.noSuchElement("Es gibt kein Element mehr");
    			return null;
    		}
    	}
    }
    	
    public static void main(String[]args) {
    	
    	//PasswordIterator iter = new PasswordIterator(4);
    	//for(int i=0; i<27;i++) {
    	//	System.out.println( i+":"+iter.next());
    	//}
    	/*while(iter.hasNext()){
    		System.out.println( iter.next());
    		
    	}
    	//System.out.println( "-----------------------------------------------------------------------------------------");*/
    
    List<Integer>a=List.of(1,2,3,1,0,-1);
    a.stream().sorted((x,y)-> y-x).forEach(x-> System.out.println(x));
    System.out.println(a.stream().reduce(1,(x,y)->x-y));
    
    String m="abc 9 |+almn";
    String X=m.substring(0, 2);
    System.out.println(X);
    String[]b=m.split("\\s|\\|");
    for(String s:b)
    	System.out.println(s);
    Map<Integer, List<String>> gk= new HashMap<>();
   
    gk.get(5).stream().forEach(s-> System.out.println(s));
    
    }
   
    
}
